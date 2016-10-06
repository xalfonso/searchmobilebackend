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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduardo
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private AdminFacade adminFacade;

    @RequestMapping(method = RequestMethod.GET)
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseJsonWrapper salvarAction(User user) {
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
