/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao;

import com.spring.web.model.Audit;
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
public class AuditLogDAO {
    
     @Autowired
    SessionFactory sessionfactory;

    public SessionFactory getSessionfactory() {
        return sessionfactory;
    }

    public void setSessionfactory(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }
     
     
     
      @Transactional
      public Audit save(Audit audit) {
        sessionfactory.getCurrentSession().saveOrUpdate(audit);
        sessionfactory.getCurrentSession().flush();
        return audit;
    }
      
      
    @Transactional
    public List<Audit> getAll() {
       List<Audit> auditList = sessionfactory.getCurrentSession().createCriteria(Audit.class).list();
        sessionfactory.getCurrentSession().flush();
        return auditList;
    }
    
    
   @Transactional
    public Audit delete(int id) {
         Audit audit = (Audit) sessionfactory.getCurrentSession().load(Audit.class, id);
        sessionfactory.getCurrentSession().delete(audit);
        sessionfactory.getCurrentSession().flush();
        return audit;
    }
    
}
