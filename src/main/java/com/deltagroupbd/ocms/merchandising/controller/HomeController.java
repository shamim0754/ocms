package com.deltagroupbd.ocms.merchandising.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("gretting","Hello message");
        return "index";
    }

}