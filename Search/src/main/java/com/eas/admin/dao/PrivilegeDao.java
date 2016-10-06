/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.dao;

import com.eas.admin.entity.Privilege;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduardo
 */
@Repository
public class PrivilegeDao {

    @Resource
    private SessionFactory sessionFactory;

    public void insertAll(List<Privilege> list) {
        for (Privilege privilege : list) {
            this.sessionFactory.getCurrentSession().save(privilege);
        }
    }

    public void insert(Privilege privilege) {
        this.sessionFactory.getCurrentSession().save(privilege);
    }

    public void update(Privilege privilege) {
        this.sessionFactory.getCurrentSession().update(privilege);
    }

    public Privilege get(long id) {
        return this.sessionFactory.getCurrentSession().load(Privilege.class, id);
    }

    public void deleteAll() {
        this.sessionFactory.getCurrentSession().createQuery("delete FROM Privilege").executeUpdate();
    }

    public List<Privilege> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("FROM Privilege").list();
    }
}
