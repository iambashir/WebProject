/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;

import com.spring.web.controller.impl.IAddServiceController;
import com.spring.web.model.AddService;
import com.spring.web.service.impl.IAddServiceService;
import java.util.List;
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
@RequestMapping(value="addService")
public class AddServiceController implements IAddServiceController{
    
     @Autowired
    IAddServiceService addService;
    
    

    @Override
    @RequestMapping(value="/create")
    public String create() {
        System.out.println("hit by service");
        
        return "/AddService/createService";
        
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
         addService.save(request);
         
         return new ModelAndView("/AddService/createService");
    }
    
    
     @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(ModelMap map){
    List<AddService> serviceList = addService.getAll();
    map.addAttribute("serviceList", serviceList);
    System.out.println("hit");
//    System.out.println(docList);
    
   
  
    return new ModelAndView("AddService/ServiceList");
    }

    @Override
    public ModelAndView edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit1(ModelMap map, @PathVariable("id") int id){
         
       AddService doc = addService.getById(id);
       map.addAttribute("doc", doc);
        
//        System.out.println(doc.getUsername() + "   print");

        return "/AddService/EditService";
    }

    @Override
     @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
         addService.update1(request);
       
       return new ModelAndView("redirect:/addService/view");
    }

    @Override
    public ModelAndView getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete1(@PathVariable("id") int id){
        addService.delete(id);
//       empDAO.delete(112);
       System.out.println("hit by delete");
//        return "redirect:/doctor/view";
        return new ModelAndView("redirect:/addService/view");
    }
    
    
    

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    

    
    
    
    
}
