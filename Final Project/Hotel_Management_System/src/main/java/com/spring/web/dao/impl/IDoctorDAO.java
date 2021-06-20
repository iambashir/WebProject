/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao.impl;

import com.spring.web.common.ICommonDAO;
import com.spring.web.model.Doctor;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IDoctorDAO extends ICommonDAO<Doctor> {
    
    public List<Doctor> searchByLname(String lastName);

    public List<Doctor> searchByLname(String lastname, String qualification);
    
    public List<Doctor> DoctorList();
    
     public Doctor DoctorProfile(String code);
    
}
