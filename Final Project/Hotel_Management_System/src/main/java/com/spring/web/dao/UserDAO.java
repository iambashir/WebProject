/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao;

import com.spring.web.dao.impl.IUserDAO;
import com.spring.web.model.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Repository
public class UserDAO implements IUserDAO{
    
    
    @Autowired
    SessionFactory sessionfactory;

    public SessionFactory getSessionfactory() {
        return sessionfactory;
    }

    public void setSessionfactory(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

   
    
    
    @Transactional
    @Override
    public User save(User user) {
       sessionfactory.getCurrentSession().saveOrUpdate(user);
       sessionfactory.getCurrentSession().flush();
        return user;
    }
    
    @Transactional
    @Override
    public User login(User user) {
       String sql = "from User where username = '"+user.getUsername()+"'";
       List<User> u = getSessionfactory().openSession().createQuery(sql).list();
       return u.get(0);
    }

    @Override
    public List getAll() {
       String sql = "from User where roleid = '1'";
        List<User> userList = getSessionfactory().openSession().createQuery(sql).list();
        return userList;
    }

    @Transactional
    @Override
    public User update(User user) {
        System.out.println(user.getId()  + " ......................... ");
        sessionfactory.getCurrentSession().saveOrUpdate(user);
        sessionfactory.getCurrentSession().flush();
        return user;
    }

    
    @Transactional
    @Override
    public User delete(int id) {
         User user = (User) sessionfactory.getCurrentSession().load(User.class, id);
        sessionfactory.getCurrentSession().delete(user);
        sessionfactory.getCurrentSession().flush();
        return user;
    }
    @Transactional
    @Override
    public User getById(int id) {
        User user = (User) sessionfactory.getCurrentSession().get(User.class, id);
//        System.out.println(doc.getId());
        sessionfactory.getCurrentSession().flush();
        return user;
    }

    @Override
    public User UserProfile(String code) {
        
        String userCode =  code;
        String sql = "from User where code = '" + userCode + "' ";
        List<User> u = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(u.get(0).getId() + " .....data");
        return u.get(0);
    }
    

    

   
    
}
