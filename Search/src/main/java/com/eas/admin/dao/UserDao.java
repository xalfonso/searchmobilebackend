/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.admin.dao;

import com.eas.admin.entity.User;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduardo
 */
@Repository
public class UserDao {

    @Resource
    private SessionFactory sessionFactory;

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserDao.class);
    
    public String test() {
        String hql = "from User1 where id=" + 1;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<User> listUser = (List<User>) query.list();
        
        
        return "probando " + listUser.get(0).getUsername();
    }
    
    public String testSave() {
        logger.trace("Ready to save");
        User u = new User();
        u.setUsername("pepitoPrimerorrffaaaa");
        sessionFactory.getCurrentSession().saveOrUpdate(u);
        return "savando pepitoPrimero";
    }
    
    public String testSave1() {
        User u = new User();
        u.setUsername("pepitosegundorrhhaaaa");
        sessionFactory.getCurrentSession().saveOrUpdate(u);
        return "savando pepitoSegundo";
    }
}
