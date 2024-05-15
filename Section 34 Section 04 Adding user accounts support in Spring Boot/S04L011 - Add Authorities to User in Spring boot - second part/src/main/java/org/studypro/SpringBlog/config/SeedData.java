package org.studypro.SpringBlog.config;

import java.util.List;

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
            authority.setId(auth.getId());
            authority.setName(auth.getPrivilege());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();

        account01.setEmail("account01@studypro.org");
        account01.setPassword("password01");
        account01.setFirstName("account01");
        account01.setLastName("lastname01");

        account02.setEmail("account02@studypro.org");
        account02.setPassword("password02");
        account02.setFirstName("account02");
        account02.setLastName("lastname02");

        accountService.save(account01);
        accountService.save(account02);


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
