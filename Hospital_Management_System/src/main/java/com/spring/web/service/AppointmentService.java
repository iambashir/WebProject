/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service;

import com.spring.web.dao.impl.IAppointmentDAO;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Appointment;
import com.spring.web.model.Doctor;
import com.spring.web.service.impl.IAppointmentService;
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
public class AppointmentService implements IAppointmentService {
    
    
     @Autowired
    IAppointmentDAO appoinDAO;
    
    
    @Override
    public Map<String, Object> save(HttpServletRequest request) {
         Map<String, String[]> map = request.getParameterMap();
         
         
         //                     For Message 
       
        Map<String, Object> obj = new HashMap<String, Object>();
          obj.put("success", "Your appointment request has been sent successfully. Thank you!");
         
         
         System.out.println("....value... " + map.get("codeDoc")[0]);
         
        String code = map.get("codeDoc")[0];
        String firstname = map.get("firstname")[0];
        String lastname = map.get("lastname")[0];
        String doctorname = map.get("nameDoc")[0];
        String email = map.get("email")[0];
        String address = map.get("address")[0];
        String mobile = map.get("mobile")[0];
        String gender = map.get("gender")[0];
        Date dateObject = new Date();
        String fronEndDateString = map.get("date")[0];
//        String time = map.get("time")[0];
        String department = map.get("department")[0];
        String branch = map.get("branch")[0];
        
        

      
        
        
        
        Appointment appoin = new Appointment();
        
        appoin.setFirstname(firstname);
        appoin.setLastname(lastname);
        appoin.setDoctorname(doctorname);
        appoin.setEmail(email);
        appoin.setAddress(address);
        appoin.setMobile(Integer.valueOf(map.get("mobile")[0]));
//        doctor.setMobile(mobile);
        appoin.setGender(gender);
        
        
        
        
        
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        appoin.setDate(dateObject);
        
        
//        appoin.setTime(time);
        
        appoin.setDepartment(department);
        appoin.setBranch(branch);
        appoin.setCode(code);
      
     
        appoinDAO.save(appoin);
        
        return obj;
    }
    
    
    
    @Override
    public void AppoinmentApprovesave(HttpServletRequest request) {
         
    }

    @Override
    public Appointment save(Appointment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> getAll() {
         List<Appointment> appoinList = appoinDAO.getAll();
        return appoinList;
    }

    @Override
    public Appointment update(Appointment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Appointment delete(int id) {
        Appointment appoin = appoinDAO.delete(id);
        return appoin;
    }

    @Override
    public Appointment getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void AppoinmentApprovesave(HttpServletRequest request, String count) {
   
    Map<String, String[]> map = request.getParameterMap();
//    String s = count;
//         int c = Integer.parseInt(s);
//        String firstname = map.get("firstname")[c];
//        System.out.println(firstname + "   dfgsdfgsretfgas");
        String firstname = map.get("firstname")[0];
        String lastname = map.get("lastname")[0];
        String doctorname = map.get("doctorname")[0];
        String email = map.get("email")[0];
        String address = map.get("address")[0];
        String mobile = map.get("mobile")[0];
        String gender = map.get("gender")[0];
        
        Date dateObject = new Date();
        String fronEndDateString = map.get("date")[0];
        String time = map.get("time")[0];
        String department = map.get("department")[0];
        String branch = map.get("branch")[0];
        String code = map.get("code")[0];
        
        
        System.out.println(lastname);
        System.out.println(fronEndDateString);
      
        
        
        
        AppoinmentApprove appoin = new AppoinmentApprove();
        
        appoin.setFirstname(firstname);
        appoin.setLastname(lastname);
        appoin.setDoctorname(doctorname);
        appoin.setEmail(email);
        appoin.setAddress(address);
        
        appoin.setMobile(Integer.valueOf(map.get("mobile")[0]));

        appoin.setGender(gender);
        
        
        
        
        
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        appoin.setDate(dateObject);
        
        
        appoin.setTime(time);
        
        appoin.setDepartment(department);
        appoin.setBranch(branch);
        appoin.setCode(code);
      
     
        appoinDAO.save(appoin); 
         
         
    }

    @Override
    public List<AppoinmentApprove> MyAppoinment(String code) {
       List<AppoinmentApprove> appoinList = appoinDAO.MyAppoinment(code);
        return appoinList;
    }

    @Override
    public List<Appointment> searchByLname(HttpServletRequest request) {
      Map<String, String[]> map = request.getParameterMap();
        String lastname = map.get("lastname")[0];
        String doctorname = map.get("doctorname")[0];
        
         System.out.println("Last name from front end " + lastname);
        List<Appointment> appList = appoinDAO.searchByLname(lastname, doctorname);
        
        return appList;
    }

    

    
    
}
