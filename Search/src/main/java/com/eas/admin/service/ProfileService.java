/*
 * Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */

package com.eas.admin.service;

import com.eas.admin.dao.ProfileDao;
import com.eas.admin.entity.Profile;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardo
 */
@Service
public class ProfileService {

    @Resource
    private ProfileDao profileDao;
    
    public void insert(Profile profile) {
        this.profileDao.insert(profile);
    }

    public void update(Profile profile) {
        this.profileDao.insert(profile);
    }

    public Profile get(long id) {
        return this.profileDao.get(id);
    }

    public void deleteAll() {
        this.profileDao.deleteAll();
    }
    
    public List<Profile> getAll() {
        return this.profileDao.getAll();
    }
}
