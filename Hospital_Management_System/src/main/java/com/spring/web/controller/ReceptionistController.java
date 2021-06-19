/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;

import com.spring.web.controller.impl.IReceptionistController;
import com.spring.web.model.Receptionist;
import com.spring.web.service.impl.IReceptionistService;
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
@RequestMapping(value="/rec")
public class ReceptionistController implements IReceptionistController{
    
    
    @Autowired
    IReceptionistService recService;

    @Override
    @RequestMapping(value="/create")
    public String create() {
        
        System.out.println(" rec");
       return "/recep/create";
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
       recService.save(request);
        return new ModelAndView("recep/create");
    }
    
     @Override
     @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(ModelMap map) {
    List<Receptionist> recList = recService.getAll();
    map.addAttribute("recList", recList);
    System.out.println("recList hit");
    return new ModelAndView("recep/Rview");
//        return "doctor/dview";
    }
    
     @RequestMapping(value = "/recpList", method = RequestMethod.GET)
    public ModelAndView ReceptionistListDoctorP(ModelMap map) {
    List<Receptionist> recList = recService.getAll();
    map.addAttribute("recList", recList);
    System.out.println("recList hit");
    return new ModelAndView("doctor/RecepList");
 
    }
    
    
    
    @RequestMapping(value = "/recpListForRecPanel", method = RequestMethod.GET)
    public ModelAndView ReceptionistListReceptionistPanel(ModelMap map) {
    List<Receptionist> recList = recService.getAll();
    map.addAttribute("recList", recList);
    System.out.println("hit by recpListForRecPanel");
    return new ModelAndView("recep/RecpListForRecPanel");
 
    }
    
    
    
    
     @Override
     @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
     public String edit1(ModelMap map, @PathVariable("id") int id){
     Receptionist rec = recService.getById(id);
     map.addAttribute("doc", rec);
     System.out.println(rec.getUsername() + "   print");

        return "/recep/Redit";
    
    }

    @Override
    public ModelAndView edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update1(ModelMap map, Receptionist recp) {
        Receptionist rec = recService.update(recp);
        
        System.out.println("hit by update");
        System.out.println(rec.getLastname());
        
        return "redirect:/doctor/view";
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
        recService.delete(id);
//       empDAO.delete(112);
       System.out.println("hit by delete");
//        return "redirect:/doctor/view";
        return new ModelAndView("redirect:/rec/view");
    }


    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @RequestMapping(value="/recepProfile/{code}",  method = RequestMethod.GET)
    public ModelAndView ReceptionistProfile(ModelMap map, @PathVariable("code") String code) {
      Receptionist rec = recService.ReceptionistProfile(code);
      map.addAttribute("rec", rec);
    return new ModelAndView("/recep/ReceptionistProfile");
    }
    
    
    @RequestMapping(value="/recepDocList")
    public String DoctorList() {
        
        System.out.println(" recep DoctorList");
       return "/recep/doctorlistForReceptionist";
    }

   
   
    
}
