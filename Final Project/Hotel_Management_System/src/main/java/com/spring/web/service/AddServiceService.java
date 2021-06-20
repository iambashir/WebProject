/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service;

import com.spring.web.dao.impl.IAddServiceDAO;
import com.spring.web.model.AddService;
import com.spring.web.model.Invoice;
import com.spring.web.service.impl.IAddServiceService;
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
public class AddServiceService implements IAddServiceService {
    
    @Autowired
    IAddServiceDAO serviceDAO;
    

    
    @Override
    public void save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        
        String servicename = map.get("servicename")[0];
        String servicecode = map.get("servicecode")[0];
        String fee = map.get("fee")[0];
        
        String duration = map.get("duration")[0];
        String category = map.get("category")[0];
        String tax = map.get("tax")[0];
        String doctorcode = map.get("doctorcode")[0];
        
        
        
        AddService service = new AddService();
        
        
        service.setServicename(servicename);
        service.setServicecode(servicecode);
        service.setFee(Double.parseDouble(map.get("fee")[0]));
        
        service.setDuration(duration);
        service.setCategory(category);
        service.setTax(Double.parseDouble(map.get("tax")[0]));
        service.setDoctorcode(doctorcode);
        
        serviceDAO.save(service);
        
        
    }
    
    
    
    
    @Override
    public AddService save(AddService t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddService> getAll() {
       List<AddService> serviceList = serviceDAO.getAll();
        return serviceList;
    }
    
    @Override
    public void update1(HttpServletRequest request) {
         Map<String, String[]> map = request.getParameterMap();
        
         
        String id = map.get("id")[0]; 
        String servicename = map.get("servicename")[0];
        String servicecode = map.get("servicecode")[0];
        String fee = map.get("fee")[0];
        
        String duration = map.get("duration")[0];
        String category = map.get("category")[0];
        String tax = map.get("tax")[0];
        String doctorcode = map.get("doctorcode")[0];
        
        
        
        AddService service = new AddService();
        
        
        service.setId(Integer.valueOf(map.get("id")[0]));
        service.setServicename(servicename);
        service.setServicecode(servicecode);
        service.setFee(Double.parseDouble(map.get("fee")[0]));
        
        service.setDuration(duration);
        service.setCategory(category);
        service.setTax(Double.parseDouble(map.get("tax")[0]));
        service.setDoctorcode(doctorcode);
        
        serviceDAO.update(service);
    }

    @Override
    public AddService update(AddService t) {
      return null;
    }

    @Override
    public AddService delete(int id) {
       AddService service = serviceDAO.delete(id);
        return service;
    }

    @Override
    public AddService getById(int id) {
      AddService service = serviceDAO.getById(id);
//        System.out.println(doc.getUsername() + " ........................serv");
        return service;
    }

   
       
    

    

    
    
}
