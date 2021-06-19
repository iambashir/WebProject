/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.AuditLog;

import com.spring.web.dao.AuditLogDAO;
import com.spring.web.model.Audit;
import java.util.Date;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */

@Aspect
@Component
public class AuditLogAspect {
    
    
//    @Autowired
//    AuditLogDAO auditLogDAO;
     
     
//     @Before("execution(* com.spring.web.controller.DoctorController.save(..))")
      public void save() {
          
        Audit audit = new Audit();
        
         System.out.println(" hit by aspect"); 
        
        audit.setAction("save");
        audit.setUsername("Nazrul");
        audit.setEmail("nazrul@gmail.com");
        audit.setRole("user");
        audit.setTime("12:20");
        audit.setDate(new Date());
        
        
//         auditLogDAO.save(audit);
      }
    
}
