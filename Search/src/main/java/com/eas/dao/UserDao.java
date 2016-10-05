/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eas.dao;

import com.eas.model.User;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
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

    
    public String test() {
        String hql = "from User1 where id=" + 1;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<User> listUser = (List<User>) query.list();
        
        
        return "probando " + listUser.get(0).getName();
    }
    
    public String testSave() {
        User u = new User();
        u.setName("pepitoPrimero");
        sessionFactory.getCurrentSession().saveOrUpdate(u);
        return "savando pepitoPrimero";
    }
    
    public String testSave1() {
        User u = new User();
        u.setName("pepitosegundo");
        sessionFactory.getCurrentSession().saveOrUpdate(u);
        return "savando pepitoSegundo";
    }
}
