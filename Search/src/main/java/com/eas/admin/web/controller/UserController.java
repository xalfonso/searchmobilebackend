/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.web.controller;

import com.eas.admin.facade.AdminFacade;
import com.eas.admin.entity.User;
import com.eas.comun.web.json.Message;
import com.eas.comun.web.json.ResponseJsonWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduardo
 */
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private AdminFacade adminFacade;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseJsonWrapper listAction() {
        Message message = null;
        List<User> users = null;
        try {
            users = this.adminFacade.getAllUser();
            message = new Message("Usuarios cargados satisfactoriamente", Message.INFO);
        } catch (Exception e) {
            message = Message.buildErrorMessage(e);
        }

        ResponseJsonWrapper responseJsonWrapper = new ResponseJsonWrapper(message, users);
        return responseJsonWrapper;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(){
        return "admin/verUser";
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertUser(){
        return "admin/insertUser";
    }
    
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseJsonWrapper salvarAction(@RequestBody User user) {
        Message message = null;
        try {
            this.adminFacade.insertUser(user);
            message = Message.buildDefaulInfoMessage();
        } catch (Exception e) {
            message = Message.buildErrorMessage(e);
        }

        ResponseJsonWrapper responseJsonWrapper = new ResponseJsonWrapper(message);
        return responseJsonWrapper;
    }    

}
