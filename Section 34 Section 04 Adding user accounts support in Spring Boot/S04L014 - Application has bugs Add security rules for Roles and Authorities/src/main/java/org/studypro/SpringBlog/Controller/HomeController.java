package org.studypro.SpringBlog.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.studypro.SpringBlog.models.Post;
import org.studypro.SpringBlog.services.PostService;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }
    @GetMapping("/editor")
    public String editor(Model model) {        
        return "editor";
    }
    @GetMapping("/profile")
    public String profile(Model model) {        
        return "profile";
    }
    @GetMapping("/test")
    public String test(Model model) {        
        return "test";
    }
}