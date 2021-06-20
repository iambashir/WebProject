/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service;

import com.spring.web.dao.impl.IDoctorDAO;
import com.spring.web.model.Doctor;
import com.spring.web.service.impl.IDoctorService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class DoctorService implements IDoctorService {
    
    @Autowired
    IDoctorDAO doctorDAO;
    
    @Override
    public Map<String, Object> save(HttpServletRequest request) {
       Map<String, String[]> map = request.getParameterMap();
       
       
//                     For Message 
       
        Map<String, Object> obj = new HashMap<String, Object>();
          obj.put("success", "Congratulations, Doctor Saved !!!");
       
       
        String firstname = map.get("firstname")[0];
        String lastname = map.get("lastname")[0];
        String username = map.get("username")[0];
        String email = map.get("email")[0];
        String password = map.get("password")[0];
        String address = map.get("address")[0];
        String mobile = map.get("mobile")[0];
        String gender = map.get("gender")[0];
        Date dateObject = new Date();
        String fronEndDateString = map.get("date")[0];
        String city = map.get("city")[0];
        String cnp = map.get("cnp")[0];
        String qualification = map.get("qualification")[0];
        String specialization = map.get("specialization")[0];
        
        String code = map.get("code")[0];
        
        

        String roleid = "2";
        
        
        
        Doctor doctor = new Doctor();
        
        doctor.setFirstname(firstname);
        doctor.setLastname(lastname);
        doctor.setUsername(username);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setAddress(address);
        doctor.setMobile(Integer.valueOf(map.get("mobile")[0]));

        doctor.setGender(gender);
        
        doctor.setRoleid(roleid);
        
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        doctor.setDate(dateObject);
        
        
        doctor.setCity(city);
        doctor.setCnp(cnp);
        doctor.setQualification(qualification);
        doctor.setSpecialization(specialization);
        doctor.setCode(code);
     
        doctorDAO.save(doctor);
        
         return obj;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return null;
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> docList = doctorDAO.getAll();
        return docList;
    }
    
     @Override
    public List<Doctor> searchByLname(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String lastname = map.get("lastname")[0];
        String qualification = map.get("qualification")[0];
        
         System.out.println("Last name from front end " + lastname);
        List<Doctor> docList = doctorDAO.searchByLname(lastname, qualification);
        
        return docList;
    }
    
    
    

    @Override
    public Doctor update(Doctor doctor) {
    
//        doctorDAO.update(doctor);
        return doctor;
    }
    
   @Override
    public void update1(HttpServletRequest request) {
        
           Map<String, String[]> map = request.getParameterMap();
           
        String id = map.get("id")[0];
        String firstname = map.get("firstname")[0];
        String lastname = map.get("lastname")[0];
        String username = map.get("username")[0];
        String email = map.get("email")[0];
        String password = map.get("password")[0];
        String address = map.get("address")[0];
        String mobile = map.get("mobile")[0];
        String gender = map.get("gender")[0];
        Date dateObject = new Date();
        String fronEndDateString = map.get("date")[0];
        String city = map.get("city")[0];
        String cnp = map.get("cnp")[0];
        String qualification = map.get("qualification")[0];
        String specialization = map.get("specialization")[0];
        
        

        String roleid = "2";
        
        
        
        Doctor doctor = new Doctor();
        
        doctor.setId(Integer.valueOf(map.get("id")[0]));
        doctor.setFirstname(firstname);
        doctor.setLastname(lastname);
        doctor.setUsername(username);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setAddress(address);
        doctor.setMobile(Integer.valueOf(map.get("mobile")[0]));
//        doctor.setMobile(mobile);
        doctor.setGender(gender);
        
        doctor.setRoleid(roleid);
        
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        doctor.setDate(dateObject);
        
        
        doctor.setCity(city);
        doctor.setCnp(cnp);
        doctor.setQualification(qualification);
        doctor.setSpecialization(specialization);
     
        doctorDAO.update(doctor);
       
    }


    @Override
    public Doctor delete(int id) {
        Doctor doc = doctorDAO.delete(id);
        return doc;
    }

    @Override
    public Doctor getById(int id) {
        Doctor doc = doctorDAO.getById(id);
//        System.out.println(doc.getUsername() + " ........................serv");
        return doc;
//        List<Doctor> docList = doctorDAO.getById(id);
//        System.out.println(docList.get(0).getUsername());
//        return docList.get(0);
    }

    @Override
    public List<Doctor> DoctorList() {
        List<Doctor> docList = doctorDAO.DoctorList();
        return docList;
    }

   
     @Override
    public Doctor DoctorProfile(String code){
        
       Doctor doc = doctorDAO.DoctorProfile(code);
       return doc;
    }
    

    
    
}
