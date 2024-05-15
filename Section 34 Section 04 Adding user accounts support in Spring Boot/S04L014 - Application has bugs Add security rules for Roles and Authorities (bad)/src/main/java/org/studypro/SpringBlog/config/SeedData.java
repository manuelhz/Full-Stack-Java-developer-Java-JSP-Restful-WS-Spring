package org.studypro.SpringBlog.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studypro.SpringBlog.models.Account;
import org.studypro.SpringBlog.models.Authority;
import org.studypro.SpringBlog.models.Post;
import org.studypro.SpringBlog.services.AccountService;
import org.studypro.SpringBlog.services.AuthorityService;
import org.studypro.SpringBlog.services.PostService;
import org.studypro.SpringBlog.util.constants.Privileges;
import org.studypro.SpringBlog.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for(Privileges auth: Privileges.values()) {
            Authority authority = new Authority();
            authority.setAuthorityId(auth.getId());
            authority.setName(auth.getPrivilege());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("user@studypro.org");
        account01.setPassword("password01");
        account01.setFirstName("User");
        account01.setLastName("Lastname01");

        account02.setEmail("admin@studypro.org");
        account02.setPassword("password02");
        account02.setFirstName("Admin");
        account02.setLastName("lastname02");
        account02.setRole(Roles.ADMIN.getRole());

        account03.setEmail("editor@studypro.org");
        account03.setPassword("password03");
        account03.setFirstName("Editor");
        account03.setLastName("lastname03");
        account03.setRole(Roles.EDITOR.getRole());

        account04.setEmail("supereditor@studypro.org");
        account04.setPassword("password04");
        account04.setFirstName("Supereditor");
        account04.setLastName("lastname04");
        account04.setRole(Roles.EDITOR.getRole());
        Set<Authority> authoties = new HashSet<>();
        authorityService.findById(Privileges.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authoties::add);
        authorityService.findById(Privileges.ACCESS_ADMIN_PANEL.getId()).ifPresent(authoties::add);
        account04.setAuthorities(authoties);


        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);


        List<Post> posts = postService.getAll();

        
        if (posts.size() == 0) {

            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("Post 01 body.........");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("Post 02 body.........");
            post02.setAccount(account02);
            postService.save(post02);
        }
    }
}