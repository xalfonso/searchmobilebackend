/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.service;

import com.eas.admin.dao.UserDao;
import com.eas.admin.entity.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduardo7
 */
@Service
@Transactional(readOnly = true)
public class UserService {
 
    @Resource
    private UserDao userDao;
    
   @Transactional
    public String test(){
      
      String b = userDao.testSave();
      String a = userDao.testSave1();
      return a + b;
    }
    
    public List<User> getAll(){
        return this.userDao.getAll();
    }
    
    @Transactional
    public void insert(User user){
        this.userDao.insert(user);
    }
    
    public void update(User user){
        this.userDao.update(user);
    }
    
    public User get(long id){
        return this.userDao.get(id);
    }
}
