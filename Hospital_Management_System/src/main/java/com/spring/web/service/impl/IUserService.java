/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service.impl;

import com.spring.web.common.ICommonService;
import com.spring.web.model.User;
import java.io.File;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
public interface IUserService extends ICommonService<User> {
     public Map<String, Object> save(HttpServletRequest request, MultipartFile file);
//     public boolean login(HttpServletRequest request);
//     public ModelAndView login1(HttpServletRequest request);
     public User login(User user);
     public User UserProfile(String code);
     
//      public Map<String, Object> save(HttpServletRequest request, MultipartFile file);
     
    
}
