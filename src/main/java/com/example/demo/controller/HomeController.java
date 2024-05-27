package com.example.demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OAuth2User user)
    {
        model.addAttribute("userName",user.getAttribute("name"));
        String userName =  Objects.requireNonNull(model.getAttribute("userName")).toString();
        return "You are logged in as "+ userName;
    }


}
