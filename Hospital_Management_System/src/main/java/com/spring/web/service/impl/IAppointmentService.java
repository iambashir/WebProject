/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service.impl;

import com.spring.web.common.ICommonService;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Appointment;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Asus
 */
public interface IAppointmentService extends ICommonService<Appointment> {
     public Map<String, Object> save(HttpServletRequest request);
     public void AppoinmentApprovesave(HttpServletRequest request);
      public List<AppoinmentApprove> MyAppoinment(String code);
       public List<Appointment> searchByLname(HttpServletRequest request);
     
    
}
