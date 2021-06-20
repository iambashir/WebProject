/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao;

import com.spring.web.dao.impl.IAddServiceDAO;
import com.spring.web.model.AddService;
import com.spring.web.model.Invoice;
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
public class AddServiceDAO implements IAddServiceDAO{
    
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
    public AddService save(AddService service) {
        sessionfactory.getCurrentSession().saveOrUpdate(service);
        sessionfactory.getCurrentSession().flush();
        return service;
    }
 
    @Transactional
    @Override
    public List<AddService> getAll() {
        List<AddService> serviceList = sessionfactory.getCurrentSession().createCriteria(AddService.class).list();
        sessionfactory.getCurrentSession().flush();
        return serviceList;
    }

    @Transactional
    @Override
    public AddService update(AddService service) {
         System.out.println(service.getId() + " ......................... ");
        sessionfactory.getCurrentSession().saveOrUpdate(service);
        sessionfactory.getCurrentSession().flush();
        return service;
    }

    @Transactional
    @Override
    public AddService delete(int id) {
        AddService service = (AddService) sessionfactory.getCurrentSession().load(AddService.class, id);
        sessionfactory.getCurrentSession().delete(service);
        sessionfactory.getCurrentSession().flush();
        return service;
    }
    
    
    @Transactional
    @Override
    public AddService getById(int id) {
      AddService service = (AddService) sessionfactory.getCurrentSession().get(AddService.class, id);
//        System.out.println(doc.getId());
        sessionfactory.getCurrentSession().flush();
        return service;
    }
    
    
    
   
    
    
    
    
    
}
