package com.deltagroupbd.ocms.merchandising.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HomeController --- program to handle admin section
 * @author    Md.Shamim Miah
 */
@Controller
public class AdminController {
	/**
   	  * redirect to admin page 
      * @exception Any exception
      * @return no return value
      */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "admin";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage() {
        return "accessdenied";
    }
    

}