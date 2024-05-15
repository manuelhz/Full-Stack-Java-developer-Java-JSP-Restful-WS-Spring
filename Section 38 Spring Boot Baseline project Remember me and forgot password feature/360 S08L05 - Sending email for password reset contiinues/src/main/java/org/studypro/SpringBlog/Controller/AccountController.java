package org.studypro.SpringBlog.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.studypro.SpringBlog.models.Account;
import org.studypro.SpringBlog.services.AccountService;
import org.studypro.SpringBlog.util.AppUtil;


import jakarta.validation.Valid;



@Controller
public class AccountController {

    // @Value("${spring.mvc.static-path-pattern}")
    // private String photo_prefix;

    @Value("${password.token.reset.timeout.minutes}")
    private int passwordTokenTimeout;

    @Autowired
    private AccountService accountService;
    
    @GetMapping("/register")
    public String register(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "account_views/register";
    }
    @PostMapping("/register")
    public String register_user(@Valid @ModelAttribute Account account, BindingResult result) {

        if (result.hasErrors()) {
            return "account_views/register";
        }

        accountService.save(account);        
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "account_views/login";
    }
    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile(Model model, Principal principal) {
        String authUser = "email";
        if(principal != null) {
            authUser = principal.getName();
        }
        Optional<Account> optionalAccount = accountService.findOneByEmail(authUser);
        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            model.addAttribute("account", account);
            model.addAttribute("photo", account.getPhoto());
            return "account_views/profile";
        } else {
            return "redirect:/?error";
        }  
        
    }
    @PostMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String postProfile(@Valid @ModelAttribute Account account, 
    BindingResult bindingResult, 
    Principal principal) {
        if (bindingResult.hasErrors()) {
            return "account_views/profile";
        }
        String authUser = "email";
        if (principal != null) {
            authUser = principal.getName();
        }
        Optional<Account> optionalAccount = accountService.findOneByEmail(authUser);
        if (optionalAccount.isPresent()) {
            Account accountById = accountService.findById(account.getAccountId()).get();
            accountById.setAge(account.getAge());
            accountById.setDateOfBirth(account.getDateOfBirth());
            accountById.setFirstName(account.getFirstName());
            accountById.setGender(account.getGender());
            accountById.setLastName(account.getLastName());
            accountById.setPassword(account.getPassword());

            accountService.save(accountById);
            SecurityContextHolder.getContext().setAuthentication(null);
            SecurityContextHolder.clearContext();

            return "redirect:/";
        } else {
            return "redirect:/?error";
        }
    }
    @PostMapping("/update_photo")
    @PreAuthorize("isAuthenticated()")
    public String updatePhoto(@RequestParam("file") MultipartFile file, 
    RedirectAttributes attributes, Principal principal) {
        if(file.isEmpty()) {
            // flashAttribure is a flush message that will be showed only once
            attributes.addFlashAttribute("error", 
            "No file uploaded");
            return "redirect:/profile";
        } else {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            System.out.println("YO:" + fileName);
            try {
                int lenght = 10;
                boolean useLetters = true;
                boolean useNumbers = true;
                String generatedString = RandomStringUtils.random(lenght, useLetters, useNumbers);
                String finalPhotoName = generatedString + fileName;
                String absoluteFileLocation = AppUtil.getUploadPath(finalPhotoName);

                Path path = Paths.get(absoluteFileLocation);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                attributes.addFlashAttribute("message", "You successfully uploaded");

                String authUser = "email";
                if (principal != null) {
                    authUser = principal.getName();
                }

                Optional<Account> optionalAccount = accountService.findOneByEmail(authUser);
                if (optionalAccount.isPresent()) {
                    Account account = optionalAccount.get();
                    Account accountById = accountService.findById(account.getAccountId()).get();
                    //String relativeFileLocation = photoPrefix.replace("**", "uploads/" + finalPhotoName);
                    String relativeFileLocation = "uploads/" + finalPhotoName;
                    accountById.setPhoto(relativeFileLocation);
                    accountService.save(accountById);
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                return "redirect:/profile";


                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return "redirect:/profile?error";
    }

    @GetMapping("/forgot-password")
    public String forgotPasword(Model model) {
        return "account_views/forgot_password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String _email, 
    RedirectAttributes attributes, 
    Model model) {
        Optional<Account> optionalAccount = accountService.findOneByEmail(_email);
        if(optionalAccount.isPresent()) {
            Account account = accountService.findById(
                optionalAccount.get().getAccountId()).get();
            String resetToken = UUID.randomUUID().toString();
            account.setPasswordResetToken(resetToken);
            account.setPasswordResetTokenExpiry(
                LocalDateTime.now().plusMinutes(passwordTokenTimeout));
            accountService.save(account);
            attributes.addFlashAttribute(
                "message", "password reset email sent");
            return "redirect:/login";
        } else {
            attributes.addFlashAttribute(
                "error", 
                "no user found with the email supplied");
            return "redirect:/forgot-password";
        }
        
        
    }


    
}