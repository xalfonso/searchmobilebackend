/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.facade.impl;

import com.eas.admin.facade.AdminFacade;
import com.eas.admin.entity.User;
import com.eas.admin.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardo
 */
@Service
public class AdminFacadeImpl implements AdminFacade{

    @Resource
    private UserService userService;
    
    @Override
    public void insertUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(long id) {
        return new User().setUsername(this.userService.test());
    }

    @Override
    public void deleteUser(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
