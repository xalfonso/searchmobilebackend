/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.web.controller;

import com.eas.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eduardo
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private UserService userService;
    
        @RequestMapping(value = "/ver", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
	    String a = this.userService.test();
            model.addAttribute("test", a);
            return "verUser";
	}
}
