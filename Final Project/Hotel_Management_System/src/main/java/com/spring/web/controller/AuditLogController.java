/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;

import com.spring.web.model.Audit;
import com.spring.web.service.AuditLogService;
import java.util.List;
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
@RequestMapping(value="/Audit")
public class AuditLogController {
    
    
     @Autowired
    AuditLogService auditLogDAO;
    
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(ModelMap map){
    List<Audit> auditList = auditLogDAO.getAll();
    map.addAttribute("auditList", auditList);
    System.out.println("hit");
//    System.out.println(auditList);
    
  
  return new ModelAndView("Audit/ViewAuditLog");

    }
    
    
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        auditLogDAO.delete(id);
//       empDAO.delete(112);
//       System.out.println("hit user by delete");

        return new ModelAndView("redirect:/Audit/view");
    }
}
