/*
 * Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */

package com.eas.admin.dao;

import com.eas.admin.entity.Privilege;
import com.eas.admin.entity.Profile;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduardo
 */
@Repository
public class ProfileDao {

    @Resource
    private SessionFactory sessionFactory;
    
    public void insert(Profile profile) {
        this.sessionFactory.getCurrentSession().save(profile);
    }

    public void update(Profile profile) {
        this.sessionFactory.getCurrentSession().update(profile);
    }

    public Profile get(long id) {
        return this.sessionFactory.getCurrentSession().load(Profile.class, id);
    }

    public void deleteAll() {
        this.sessionFactory.getCurrentSession().createQuery("delete FROM Profile").executeUpdate();
    }
    
    
    public List<Profile> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("FROM Profile").list();
    }
}
