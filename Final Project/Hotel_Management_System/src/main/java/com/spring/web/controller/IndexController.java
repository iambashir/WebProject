/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;

import com.spring.web.service.AppointmentService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
@Controller
//@RequestMapping(value = "/doctor")
public class IndexController {
    
    
     @Autowired
    AppointmentService appoinService;
    
    
    
    
  
    @RequestMapping(value = "/admin")
    public String Admin() {
        
    System.out.println("hit by admin");
        return "/admin/adminpanel";

    }
    
    @RequestMapping(value="/doctor")
    public String Doctor() {
        System.out.println("hit by doctor");
       return "doctor/doctorpanel";
    }
    
    @RequestMapping(value="/Receptionist")
    public String Receptionist() {
        System.out.println("hit by Receptionist");
       return "recep/Receptionistpanel";
    }
    
    
    
    @RequestMapping(value = "/index")
    public String Index() {
        
    System.out.println("hit by index");
        return "/admin/index";

    }
    
    
//    @RequestMapping(value = "/AppoinSave", method = RequestMethod.POST)
//    public ModelAndView save(HttpServletRequest request) {
//        appoinService.save(request);
//        
//        System.out.println("hit index by appoinment");
//        return new ModelAndView("/admin/TempletAppoinment");
//    }
    
    
     
    @RequestMapping(value = "/index2")
    public String Index2() {
        
    System.out.println("hit by index2");
        return "/admin/inner-page";

    }
    
    @RequestMapping(value = "/index3")
    public String Index3() {
        
    System.out.println("hit by index2");
        return "/admin/new";

    }
    
    @RequestMapping(value = "/index4")
    public String Index4() {
        
    System.out.println("hit by index2");
        return "/admin/Invoice";

    }
    
    
    
    
}
