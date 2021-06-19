/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service.impl;

import com.spring.web.common.ICommonService;
import com.spring.web.model.Doctor;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Asus
 */
public interface IDoctorService extends ICommonService<Doctor> {
    public Map<String, Object> save(HttpServletRequest request);
    public void update1(HttpServletRequest request);
    public List<Doctor> searchByLname(HttpServletRequest request);
    public List<Doctor> DoctorList();
    public Doctor DoctorProfile(String code);
}
