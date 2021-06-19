/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao;

import com.spring.web.dao.impl.IDoctorDAO;
import com.spring.web.model.Doctor;
import com.spring.web.model.User;
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
public class DoctorDAO implements IDoctorDAO {

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
    public Doctor save(Doctor doctor) {
        sessionfactory.getCurrentSession().saveOrUpdate(doctor);
        sessionfactory.getCurrentSession().flush();
        return doctor;
    }

    @Transactional
    @Override
    public List<Doctor> getAll() {

//           String roleid = "2";
//           Doctor doc = new Doctor();
//           doc.setRoleid("roleid");
        String sql = "from Doctor where roleid = '2'";
        List<Doctor> docList = getSessionfactory().openSession().createQuery(sql).list();
        return docList;

//       return u.get(0);
//        List<Doctor> docList = sessionfactory.getCurrentSession().createCriteria(Doctor.class).list();
//        sessionfactory.getCurrentSession().flush();
//        return docList;
    }

    @Override
    public List<Doctor> searchByLname(String lastName) {
        //Doctor doc = new Doctor();

        String searchString = "%"+lastName;
        
        String sql = "from Doctor where lastname LIKE '" + searchString + "'";
        List<Doctor> docList = getSessionfactory().openSession().createQuery(sql).list();
        return docList;
    }

    @Transactional
    @Override
    public Doctor update(Doctor doctor) {
        System.out.println(doctor.getId() + " ......................... ");
        sessionfactory.getCurrentSession().saveOrUpdate(doctor);
        sessionfactory.getCurrentSession().flush();
        return doctor;
    }

    @Transactional
    @Override
    public Doctor delete(int id) {
        Doctor doc = (Doctor) sessionfactory.getCurrentSession().load(Doctor.class, id);
        sessionfactory.getCurrentSession().delete(doc);
        sessionfactory.getCurrentSession().flush();
        return doc;
    }

    @Transactional
    @Override
    public Doctor getById(int id) {
        Doctor doc = (Doctor) sessionfactory.getCurrentSession().get(Doctor.class, id);
//        System.out.println(doc.getId());
        sessionfactory.getCurrentSession().flush();
        return doc;
    }

    @Override
    public List<Doctor> searchByLname(String lastname, String qualification) {
        
        String searchString = "%"+lastname+"%";
        String searchQualification = "%"+qualification+"%";
        
        String sql = "from Doctor where lastname LIKE '" + searchString + "' AND qualification LIKE '" + searchQualification + "'";
        List<Doctor> docList = getSessionfactory().openSession().createQuery(sql).list();
        return docList;
    }

    @Transactional
    @Override
    public List<Doctor> DoctorList() {
       String sql = "from Doctor where roleid = '2'";
        List<Doctor> docList = getSessionfactory().openSession().createQuery(sql).list();
        return docList;
    }

    @Override
    public Doctor DoctorProfile(String code) {
        String docCode =  code;
        String sql = "from Doctor where code = '" + docCode + "' ";
        List<Doctor> doc = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(doc.get(0).getId() + " .....data");
        return doc.get(0);
    }

}
