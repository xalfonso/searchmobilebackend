/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.service;

import com.eas.admin.dao.UserDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduardo
 */
@Service
public class UserService {
 
    @Resource
    private UserDao userDao;
    
   @Transactional
    public String test(){
      
      String b = userDao.testSave();
      String a = userDao.testSave1();
      return a + b;
    }
}
