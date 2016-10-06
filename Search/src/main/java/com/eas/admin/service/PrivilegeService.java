/*
 * Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */
package com.eas.admin.service;

import com.eas.admin.dao.PrivilegeDao;
import com.eas.admin.entity.Privilege;
import com.eas.admin.entity.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduardo
 */

@Service
@Transactional(readOnly = true)
public class PrivilegeService {
 
    @Resource
    private PrivilegeDao privilegeDao;
    
    public List<Privilege> getAll(){
        return this.privilegeDao.getAll();
    }
    
    @Transactional
    public void insert(Privilege privilege){
        this.privilegeDao.insert(privilege);
    }
    
    @Transactional
    public void insertAll(List<Privilege> privileges){
        this.privilegeDao.insertAll(privileges);
    }
    
    @Transactional
    public void resetPrivileges() throws Exception{
        this.privilegeDao.deleteAll();
        this.privilegeDao.insertAll(Privilege.getAllPrivileges());
    }
        
    public void update(Privilege privilege){
        this.privilegeDao.update(privilege);
    }
    
    public Privilege get(long id){
        return this.privilegeDao.get(id);
    }
    
}
