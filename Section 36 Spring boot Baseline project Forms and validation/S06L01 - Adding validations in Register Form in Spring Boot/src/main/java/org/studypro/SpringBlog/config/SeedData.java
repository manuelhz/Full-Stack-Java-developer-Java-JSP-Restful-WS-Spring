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
            post01.setTitle("About Git");
            post01.setBody("""
                Git (/ɡɪt/)[8] is a distributed version control system[9] that tracks changes in any set of computer files, usually used for coordinating work among programmers who are collaboratively developing source code during software development. Its goals include speed, data integrity, and support for distributed, non-linear workflows (thousands of parallel branches running on different computers).[10][11][12]

Git was originally authored by Linus Torvalds in 2005 for development of the Linux kernel, with other kernel developers contributing to its initial development.[13] Since 2005, Junio Hamano has been the core maintainer. As with most other distributed version control systems, and unlike most client–server systems, every Git directory on every computer is a full-fledged repository with complete history and full version-tracking abilities, independent of network access or a central server.[14] Git is free and open-source software shared under the GPL-2.0-only license.

Since its creation, Git has become the most popular distributed version control system, with nearly 95% of developers reporting it as their primary version control system as of 2022.[15] There are many popular offerings of Git repository services, including GitHub, SourceForge, Bitbucket and GitLab.[16][17][18][19][20] 
            """);
            

            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Model–view–controller");
            post02.setBody("""
                Model–view–controller (MVC) is a software design pattern[1] commonly used for developing user interfaces that divides the related program logic into three interconnected elements. These elements are the internal representations of information (the model), the interface (the view) that presents information to and accepts it from the user, and the controller software linking the two.[2][3]

            Traditionally used for desktop graphical user interfaces (GUIs), this pattern became popular for designing web applications.[4] Popular programming languages have MVC frameworks that facilitate the implementation of the pattern. 
            """);
            post02.setAccount(account02);
            postService.save(post02);
        }
    }
}