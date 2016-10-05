/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.web.controller;

import com.eas.admin.facade.AdminFacade;
import com.eas.admin.entity.User;
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
    private AdminFacade adminFacade;

    @RequestMapping(value = "/ver", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        User a = this.adminFacade.getUser(0);
        model.addAttribute("test", a.getUsername());
        return "verUser";
    }
}
