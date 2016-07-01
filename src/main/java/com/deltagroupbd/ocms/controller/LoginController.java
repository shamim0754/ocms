package com.deltagroupbd.ocms.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    
    @RequestMapping("/login")
    String login(Model model) {
        return "login";
    }
    @RequestMapping("/access_denied")
    public String accessDeniedPage(Model model) {
        return "accessdenied";
    }

}