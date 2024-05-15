package org.studypro.SpringBlog.Controller;


import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.studypro.SpringBlog.models.Account;
import org.studypro.SpringBlog.models.Post;
import org.studypro.SpringBlog.services.AccountService;
import org.studypro.SpringBlog.services.PostService;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model, Principal principal) {

        Optional<Post> optionalPost = postService.getById(id);

        String authUser = "email";

        if(optionalPost.isPresent()) {

            Post post = optionalPost.get();
            model.addAttribute("post", post);

            // get username of current loggec in session user
            // String authUsername = SecurityContextHolder.getContext().getAuthentication().getName()
            if (principal != null) {
                authUser = principal.getName();
            }
            if (authUser.equals(post.getAccount().getEmail())) {
                model.addAttribute("isOwner", true);
            } else {
                model.addAttribute("isOwner", false);
            }

            return "post_views/post";

        } else {
            return "404";
        }
    }



    @GetMapping("/posts/add")
    @PreAuthorize("isAuthenticated()")
    public String addPost(Model model, Principal principal) {

        String authUser = "email";
        if( principal != null) {
            authUser = principal.getName();
        }
        Optional<Account> optionalAccount = accountService.findOneByEmail(authUser);
        if(optionalAccount.isPresent()) {
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            return "post_views/post_add";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/posts/add")
    @PreAuthorize("isAuthenticated()")
    public String addPostHandler(@ModelAttribute Post post, Principal principal) {
        String authUser = "email";
        if (principal != null) {
            authUser = principal.getName();
        }
        if (post.getAccount().getEmail().compareToIgnoreCase(authUser) < 0) {
            return "redirect:/?error";
        }
        postService.save(post);
        return "redirect:/post/" + post.getPostId();
    }    
}
    
