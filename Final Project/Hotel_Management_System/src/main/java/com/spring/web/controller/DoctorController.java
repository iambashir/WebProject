/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;


import com.spring.web.controller.impl.IDoctorController;
import com.spring.web.model.Doctor;
import com.spring.web.service.impl.IDoctorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
@Controller
@RequestMapping(value="/doctor")
public class DoctorController implements IDoctorController{

    @Autowired
    IDoctorService doctorService;
    
//    @RequestMapping(value="/create")
//    public String create1() {
//        System.out.println("hit by doctor");
//        return "/doctor/create";
//    }

    @Override
    @RequestMapping(value="/create")
    public String create() {
       return "/doctor/create";
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
//           doctorService.save(request);

            
           
            Map<String, Object> map = doctorService.save(request);
            return new ModelAndView("/doctor/create", "map", map);
    }
    
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView save1(ModelMap map, @ModelAttribute("ggg")Doctor doc) {
//       doctorService.save(doc);
//        map.addAttribute("Message" ,"data save");
//
//        return new ModelAndView("doctor/create");
//    }
    
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(ModelMap map){
    List<Doctor> docList = doctorService.getAll();
    map.addAttribute("docList", docList);
    System.out.println("hit");
    System.out.println(docList);
    
   
  
    return new ModelAndView("doctor/dview");
//        return "doctor/dview";
    }
    
    @Override
    @RequestMapping(value = "/viewByLName", method = RequestMethod.POST)
    public ModelAndView searchByLname(ModelMap map, HttpServletRequest request) {
       //Map<String, String[]> model = request.getParameterMap();
       
       List<Doctor> docList = doctorService.searchByLname(request);
        map.addAttribute("docList", docList);
        
       System.out.println(docList);
        
        System.out.println(" hit by viewByLName for admin");
       
       return new ModelAndView("doctor/dview");
    }
    
    
    @RequestMapping(value = "/searchByLName", method = RequestMethod.POST)
    public ModelAndView searchForRecepPanel(ModelMap map, HttpServletRequest request) {
       //Map<String, String[]> model = request.getParameterMap();
       
       List<Doctor> dList = doctorService.searchByLname(request);
        map.addAttribute("dList", dList);
        
       System.out.println(dList);
        
        System.out.println(" hit by viewByLName for doctor");
       
       return new ModelAndView("doctor/doctorlist");
    }
    
    
    
    
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit1(ModelMap map, @PathVariable("id") int id){
         
        Doctor doc = doctorService.getById(id);
        map.addAttribute("doc", doc);
         System.out.println(doc.getUsername() + "   print");

        return "/doctor/dedit";
    }

    @Override
    public ModelAndView edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String update1(ModelMap map, @ModelAttribute("doctor") Doctor doctor) {
//        
//        Doctor doc = doctorService.update(doctor);
//        
//        System.out.println("hit by update");
//        System.out.println(doc.getLastname());
//        
//        return "redirect:/doctor/view";
////       
//    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        doctorService.update1(request);
       
       return new ModelAndView("redirect:/doctor/view");
    }

    @Override
    public ModelAndView getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete1(ModelMap map, @PathVariable("id") int id){
        doctorService.delete(id);

//       System.out.println("hit by delete");

         Map<String, Object> obj = new HashMap<String, Object>();
         obj.put("success", "Congratulations, Doctor Deleted !!!");
        
        return new ModelAndView("redirect:/doctor/view" , "map", obj);
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @RequestMapping(value = "/doctorview", method = RequestMethod.GET)
    public ModelAndView DoctorView(ModelMap map){
  
    List<Doctor> dList = doctorService.DoctorList();
    map.addAttribute("dList", dList);
    System.out.println(" doctor hit");
  
    return new ModelAndView("doctor/doctorlist");

    }
    
     @RequestMapping(value="/recepDocList", method = RequestMethod.GET)
     public ModelAndView DoctorList(ModelMap map) {
        
     List<Doctor> dList = doctorService.DoctorList();
     map.addAttribute("dList", dList);
        
        System.out.println(" recep DoctorList");
      
       return new ModelAndView("/recep/doctorlistForReceptionist");
    }
    
    
    
    
    @RequestMapping(value="/DoctorProfile/{code}",  method = RequestMethod.GET)
    public ModelAndView DoctorProfile(ModelMap map, @PathVariable("code") String code) {
      Doctor doc = doctorService.DoctorProfile(code);
      map.addAttribute("doc", doc);
    return new ModelAndView("/doctor/doctorProfile");
    }
    
    
    

     

    
}