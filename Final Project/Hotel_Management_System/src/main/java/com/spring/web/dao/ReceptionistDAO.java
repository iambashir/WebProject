/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao;

import com.spring.web.dao.impl.IReceptionistDAO;
import com.spring.web.model.Receptionist;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
 

@Repository
public class ReceptionistDAO implements IReceptionistDAO {
    
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
    public Receptionist save(Receptionist rec) {
       sessionfactory.getCurrentSession().saveOrUpdate(rec);
       sessionfactory.getCurrentSession().flush();
        return rec;
    }

    @Transactional
    @Override
    public List<Receptionist> getAll() {
        String sql = "from Doctor where roleid = '3'";
        List<Receptionist> recList = getSessionfactory().openSession().createQuery(sql).list();
        return recList;
    }

    @Transactional
    @Override
    public Receptionist update(Receptionist rec) {
        System.out.println(rec.getId()  + " ......................... ");
        sessionfactory.getCurrentSession().saveOrUpdate(rec);
        sessionfactory.getCurrentSession().flush();
        return rec;
    }

    @Transactional
    @Override
    public Receptionist delete(int id) {
        Receptionist rec = (Receptionist) sessionfactory.getCurrentSession().load(Receptionist.class, id);
        sessionfactory.getCurrentSession().delete(rec);
        sessionfactory.getCurrentSession().flush();
        return rec;
    }
 
    @Transactional
    @Override
    public Receptionist getById(int id) {
         Receptionist rec = (Receptionist) sessionfactory.getCurrentSession().get(Receptionist.class, id);
//        System.out.println(doc.getId());
        sessionfactory.getCurrentSession().flush();
          return rec;
    }

    @Override
    public Receptionist ReceptionistProfile(String code) {
       String recCode =  code;
        String sql = "from Receptionist where code = '" + recCode + "' ";
        List<Receptionist> doc = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(doc.get(0).getId() + " .....data");
        return doc.get(0);
    }
    
    
    
    
    
    }
    
    

