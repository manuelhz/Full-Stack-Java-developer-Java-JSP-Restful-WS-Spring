package org.studypro.SpringRestDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/")
    public String demo() {
        return "Hello world";
    }
    
}
