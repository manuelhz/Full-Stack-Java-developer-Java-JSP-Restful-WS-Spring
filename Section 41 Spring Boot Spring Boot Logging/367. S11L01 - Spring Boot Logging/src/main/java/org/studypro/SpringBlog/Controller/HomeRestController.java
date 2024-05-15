package org.studypro.SpringBlog.Controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.studypro.SpringBlog.models.Post;
import org.studypro.SpringBlog.services.PostService;



@RestController
@RequestMapping("/api/v1")
public class HomeRestController {

    @Autowired
    private PostService postService;
    
    Logger logger = LoggerFactory.getLogger(HomeRestController.class);

    @GetMapping("/")
    public String home() {

        //levels of log: trace < debug < info < warn < error
        logger.debug("This is a test error log");
        return "sample response"; 
    }
    /* 
    
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
    */
}