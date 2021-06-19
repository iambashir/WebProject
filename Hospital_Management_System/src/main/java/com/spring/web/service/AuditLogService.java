/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service;

import com.spring.web.dao.AuditLogDAO;
import com.spring.web.model.Audit;
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
public class AuditLogService {
    
     @Autowired
    AuditLogDAO auditDAO;
    
    
     public void save(HttpServletRequest request) {
       Map<String, String[]> map = request.getParameterMap();
       
        String action = map.get("action")[0];
        String username = map.get("username")[0];
        String email = map.get("email")[0];
        String role = map.get("role")[0];
        
        String time = map.get("time")[0];
        
        Date dateObject = new Date();
        String fronEndDateString = map.get("date")[0];
        
        
        Audit audit = new Audit();
        
        audit.setAction(action);
        audit.setUsername(username);
        audit.setEmail(email);
        audit.setRole(role);
        audit.setTime(time);
        
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        audit.setDate(dateObject);
        
        
//         auditDAO.save(audit);
       
       
      
       
     }
     
      public List<Audit> getAll() {
        List<Audit> auditList = auditDAO.getAll();
        return auditList;
    }
     
     
      public Audit delete(int id) {
        Audit audit = auditDAO.delete(id);
        return audit;
    }
    
}
