package com.deltagroupbd.ocms.merchandising.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HomeController --- program to print "Hello message".
 * @author    Md.Shamim Miah
 */
@Controller
public class HomeController {
	/**
   	  * Prints out "Hello message" 
      * @param model containing request attribute
      * @exception Any exception
      * @return index
      */
    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("gretting","Hello message");
        return "index";
    }

}