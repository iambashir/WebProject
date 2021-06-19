/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service.impl;

import com.spring.web.common.ICommonService;
import com.spring.web.model.AddService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Asus
 */
public interface IAddServiceService extends ICommonService<AddService>{
    
    public void save(HttpServletRequest request);
   
    public void update1(HttpServletRequest request);
    
    
}
