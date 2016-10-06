/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.facade.impl;

import com.eas.admin.entity.Privilege;
import com.eas.admin.entity.Profile;
import com.eas.admin.facade.AdminFacade;
import com.eas.admin.entity.User;
import com.eas.admin.service.PrivilegeService;
import com.eas.admin.service.ProfileService;
import com.eas.admin.service.UserService;
import java.util.List;
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
    
    @Resource
    private PrivilegeService privilegeService;
    
    @Resource
    private ProfileService profileService;
    
    @Override
    public void insertUser(User user) {
        this.userService.insert(user);
    }

    @Override
    public User getUser(long id) {
        return this.userService.get(id);
    }

    @Override
    public void deleteUser(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUser() {
        return this.userService.getAll();
    }

    @Override
    public void updateUser(User user) {
        this.userService.update(user);
    }
    

    @Override
    public void insertPrivilge(Privilege privilege) {
        this.privilegeService.insert(privilege);
    }

    @Override
    public void insertAllPrivilege(List<Privilege> privileges) {
        this.privilegeService.insertAll(privileges);
    }

    @Override
    public void updatePrivilege(Privilege privilge) {
        this.privilegeService.update(privilge);
    }

    @Override
    public Privilege getPrivilege(long id) {
        return this.privilegeService.get(id);
    }

    @Override
    public List<Privilege> getAllPrivilege() {
        return this.privilegeService.getAll();
    }

    @Override
    public void resetPrivileges() throws Exception{
        this.privilegeService.resetPrivileges();
    }

    @Override
    public void insertProfile(Profile profile) {
        this.profileService.insert(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        this.profileService.update(profile);
    }

    @Override
    public Profile getProfile(long id) {
        return this.profileService.get(id);
    }

    @Override
    public List<Profile> getAllProfile() {
        return this.profileService.getAll();
    }

    @Override
    public void deleteAllProfile() {
        this.profileService.deleteAll();
    }
    
}
