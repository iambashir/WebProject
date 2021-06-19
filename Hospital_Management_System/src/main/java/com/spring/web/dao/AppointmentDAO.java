/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao;

import com.spring.web.dao.impl.IAppointmentDAO;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Appointment;
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
public class AppointmentDAO implements IAppointmentDAO {
    
    
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
    public Appointment save(Appointment appoin) {
       sessionfactory.getCurrentSession().saveOrUpdate(appoin);
       sessionfactory.getCurrentSession().flush();
        return appoin;
    }
    
    
    @Transactional
    @Override
    public AppoinmentApprove save(AppoinmentApprove appoin) {
       sessionfactory.getCurrentSession().saveOrUpdate(appoin);
       sessionfactory.getCurrentSession().flush();
        return appoin;
    }
    
    
    
    

    @Transactional
    @Override
    public List<Appointment> getAll() {
       List<Appointment> appoinList = sessionfactory.getCurrentSession().createCriteria(Appointment.class).list();
        sessionfactory.getCurrentSession().flush();
        return appoinList;
    }

    @Override
    public Appointment update(Appointment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public Appointment delete(int id) {
        Appointment appoin = (Appointment) sessionfactory.getCurrentSession().load(Appointment.class, id);
        sessionfactory.getCurrentSession().delete(appoin);
        sessionfactory.getCurrentSession().flush();
        return appoin;
    }

    @Override
    public Appointment getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AppoinmentApprove> MyAppoinment(String code) {
        
        String docCode =  code;
        System.out.println(code+"from DAO---------");
        
        String sql = "from AppoinmentApprove where code = '" + docCode + "' ";
        List<AppoinmentApprove> appoinList = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(appoinList.get(0).getId() + " .....data");
        return appoinList;
    }

    @Override
    public List<Appointment> searchByLname(String lastname, String doctorname) {
       String searchString = "%"+lastname+"%";
       String searchDoctorname = "%"+doctorname+"%";
        
        String sql = "from Appointment where lastname LIKE '" + searchString + "' AND doctorname LIKE '" + searchDoctorname + "'";
        List<Appointment>appList = getSessionfactory().openSession().createQuery(sql).list();
        return appList;
    }

    
    
}
