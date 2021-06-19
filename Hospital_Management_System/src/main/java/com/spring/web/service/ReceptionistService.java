/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service;

import com.spring.web.dao.impl.IReceptionistDAO;
import com.spring.web.model.Doctor;
import com.spring.web.model.Receptionist;
import com.spring.web.service.impl.IReceptionistService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ReceptionistService implements IReceptionistService{
    
    
    @Autowired
    IReceptionistDAO recDAO;
    
    @Override
    public void save(HttpServletRequest request) {
       Map<String, String[]> map = request.getParameterMap();
       
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
        

        String roleid = "3";
        
        
        
        Receptionist rece = new Receptionist();
        
        rece.setFirstname(firstname);
        rece.setLastname(lastname);
        rece.setUsername(username);
        rece.setEmail(email);
        rece.setPassword(password);
        rece.setAddress(address);
        rece.setMobile(Integer.valueOf(map.get("mobile")[0]));
//        doctor.setMobile(mobile);
        rece.setGender(gender);
        
        rece.setRoleid(roleid);
        
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        rece.setDate(dateObject);
        
        
        rece.setCity(city);
        rece.setCnp(cnp);
        rece.setQualification(qualification);
        rece.setSpecialization(specialization);
        rece.setCode(code);
     
        recDAO.save(rece);
    }

    @Override
    public Receptionist save(Receptionist t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Receptionist> getAll() {
       List<Receptionist> recList = recDAO.getAll();
        return recList;
    }

    @Override
    public Receptionist update(Receptionist rec) {
       recDAO.update(rec);
        return rec;
    }

    @Override
    public Receptionist delete(int id) {
        Receptionist rec = recDAO.delete(id);
        return rec;
    }

    @Override
    public Receptionist getById(int id) {
       Receptionist rec = recDAO.getById(id);
       return rec;
    }

    @Override
    public Receptionist ReceptionistProfile(String code) {
       Receptionist rec = recDAO.ReceptionistProfile(code);
       return rec;
    }

    
    
}
