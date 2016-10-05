/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.facade;

import com.eas.admin.entity.User;

/**
 *
 * @author eduardo
 */
public interface AdminFacade {
    
    public void insertUser(User user);
    
    public User getUser(long id);
    
    public void deleteUser(long id);
}
