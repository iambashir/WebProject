/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;

import com.spring.web.controller.impl.IAppointmentController;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Appointment;
import com.spring.web.model.Doctor;
import com.spring.web.service.AppointmentService;
import com.spring.web.service.DoctorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
@Controller
@RequestMapping(value="/appoin")
public class AppointmentController implements IAppointmentController {
    
     @Autowired
    AppointmentService appoinService;
     
     @Autowired
     DoctorService doctorService;
    
    
    @Override
    @RequestMapping(value="/create")
    public ModelAndView create1(ModelMap map) {
        List<Doctor> docs = doctorService.getAll();
       
        map.addAttribute("docs", docs);
       return new ModelAndView("/appointment/create");
    }
    
    
    
    @RequestMapping(value="/TempletApoin")
    public ModelAndView TampletAppoincreate(ModelMap map) {
        List<Doctor> docs = doctorService.getAll();
       
        map.addAttribute("docs", docs);
       
       return new ModelAndView("/appointment/TempletAppoinment");
    }
    
    
    @RequestMapping(value="/CreateAppointmentForReceptionist")
    public ModelAndView CreateAppoinementForReceptionist(ModelMap map) {
        List<Doctor> docs = doctorService.getAll();
       
        map.addAttribute("docs", docs);
       
       return new ModelAndView("/recep/CreateAppoinmentForReceptionist");
    }
    
    
    
    
    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
//        appoinService.save(request);
        Map<String, Object> map = appoinService.save(request);
        
        System.out.println("hit by appoinment");
        return new ModelAndView("appointment/create", "map", map);
    }
    
    @RequestMapping(value = "/AppoinSave", method = RequestMethod.POST)
    public ModelAndView saveFormTemplet(HttpServletRequest request) {
//        appoinService.save(request);
        
         System.out.println("hit index by appoinment");
         Map<String, Object> map = appoinService.save(request);
            return new ModelAndView("/appointment/TempletAppoinment", "map", map);

    }
    
    
    
     @RequestMapping(value = "/SaveFormReceptionist", method = RequestMethod.POST)
    public ModelAndView saveFormReceptionist(HttpServletRequest request) {
//        appoinService.save(request);
        
         System.out.println("hit index by appoinment");
         Map<String, Object> map = appoinService.save(request);
            return new ModelAndView("/recep/CreateAppoinmentForReceptionist", "map", map);

    }
    
    
    
    
    
    
    @RequestMapping(value = "/AppoinmentApproveSave/{count}", method = RequestMethod.POST)
    public ModelAndView AppoinmentApprovesave(HttpServletRequest request, @PathVariable String count) {
          Map<String, String[]> map = request.getParameterMap();
        appoinService.AppoinmentApprovesave(request, count);
        
            System.out.println(map.get("lastname")[0]);
            System.out.println(map.get("time")[0]);
  
        return new ModelAndView("redirect:/appoin/view");
        
    }
    
    
    
    
    @RequestMapping(value = "/AppoinmentApproveSaveforReceptionist/{count}", method = RequestMethod.POST)
    public ModelAndView AppoinmentApprovesaveForRecptionist(HttpServletRequest request, @PathVariable String count) {
          Map<String, String[]> map = request.getParameterMap();
        appoinService.AppoinmentApprovesave(request, count);
        
            System.out.println(map.get("lastname")[0]);
            System.out.println(map.get("time")[0]);
  
        return new ModelAndView("redirect:/appoin/viewForReceptionist");
        
    }
    
    
    
    
    
    
    
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(ModelMap map){
    List<Appointment> appoinList = appoinService.getAll();
    map.addAttribute("appoinList", appoinList);
    System.out.println("hit");
    return new ModelAndView("appointment/appoinview");
//        return "doctor/dview";
    }
    
    
    
    @RequestMapping(value = "/viewForReceptionist", method = RequestMethod.GET)
    public ModelAndView ViewForReceptionist(ModelMap map){
    List<Appointment> appoinList = appoinService.getAll();
    map.addAttribute("appoinList", appoinList);
    System.out.println("hit");
    return new ModelAndView("recep/AppoinmentListForReceptionist");

    }
    
   
    
    
    
    @RequestMapping(value="/MyAppoinment/{code}",  method = RequestMethod.GET)
    
    public ModelAndView MyAppoinment(ModelMap map, @PathVariable("code") String username) {
      List<AppoinmentApprove> appoinList = appoinService.MyAppoinment(username);
       map.addAttribute("appoinList", appoinList);

          System.out.println(username+"---From controller");
        
         System.out.println("My appoinment");
       return new ModelAndView("doctor/MyAppoinment");
    }
    
    

    @Override
    public ModelAndView edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete1(@PathVariable("id") int id){
        appoinService.delete(id);
//       empDAO.delete(112);
       System.out.println("hit by delete");
//        return "redirect:/doctor/view";
        return new ModelAndView("redirect:/appoin/view");
    }
    
    
    
    @RequestMapping(value = "/searchByLName", method = RequestMethod.POST)
    public ModelAndView AppoinmentSerchByname(ModelMap map, HttpServletRequest request) {
       //Map<String, String[]> model = request.getParameterMap();
       
       List<Appointment> appoinList = appoinService.searchByLname(request);
        map.addAttribute("appoinList", appoinList);
        
       System.out.println(appoinList);
        
        System.out.println(" hit by viewByLName for doctor");
       
       return new ModelAndView("recep/AppoinmentListForReceptionist");
    }
    
    
    
     @RequestMapping(value = "/searchByLNameForAdmin", method = RequestMethod.POST)
    public ModelAndView AppoinmentSerchBynameForAdmin(ModelMap map, HttpServletRequest request) {
       //Map<String, String[]> model = request.getParameterMap();
       
       List<Appointment> appoinList = appoinService.searchByLname(request);
        map.addAttribute("appoinList", appoinList);
        
       System.out.println(appoinList);
        
        System.out.println(" hit by viewByLName for doctor");
       
       return new ModelAndView("appointment/appoinview");
    }
    

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    @RequestMapping(value = "/PatientList", method = RequestMethod.GET)
    public ModelAndView PatientListForAdmin(ModelMap map){
    List<Appointment> appoinList = appoinService.getAll();
    map.addAttribute("appoinList", appoinList);
    System.out.println("hot patient list");
    return new ModelAndView("Patient/PatientListForAdmin");

    }
    
    
    @RequestMapping(value = "/PatientListforReceptionist", method = RequestMethod.GET)
    public ModelAndView PatientListForReceptionst(ModelMap map){
    List<Appointment> appoinList = appoinService.getAll();
    map.addAttribute("appoinList", appoinList);
    System.out.println("hot patient list");
    return new ModelAndView("Patient/PatientListForReciptionist");

    }
    
}
