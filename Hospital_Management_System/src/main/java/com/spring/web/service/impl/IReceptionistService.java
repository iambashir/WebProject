/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service.impl;

import com.spring.web.common.ICommonService;
import com.spring.web.model.Receptionist;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Asus
 */
public interface IReceptionistService extends ICommonService<Receptionist> {
    public void save(HttpServletRequest request);
    public Receptionist ReceptionistProfile(String code);
    
}
