/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.facade;

import com.eas.admin.entity.Privilege;
import com.eas.admin.entity.Profile;
import com.eas.admin.entity.User;
import java.util.List;

/**
 *
 * @author eduardo
 */
public interface AdminFacade {
    
    public void insertUser(User user);
    
    public void updateUser(User user);
    
    public User getUser(long id);
    
    public void deleteUser(long id);
    
    public List<User> getAllUser();
    
    public void insertPrivilge(Privilege privilege);
    
    public void insertAllPrivilege(List<Privilege> privileges);
    
    public void updatePrivilege(Privilege privilge);
    
    public Privilege getPrivilege(long id);
            
    public List<Privilege> getAllPrivilege();
    
    public void resetPrivileges() throws Exception;
    
    public void insertProfile(Profile profile);
    
    public void updateProfile(Profile profile);
    
    public Profile getProfile(long id);
    
    public List<Profile> getAllProfile();
    
    public void deleteAllProfile();
}
