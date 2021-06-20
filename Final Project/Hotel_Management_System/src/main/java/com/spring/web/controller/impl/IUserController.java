/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller.impl;

import com.spring.web.common.ICommonController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
public interface IUserController extends ICommonController {
    public ModelAndView loginAction(ModelMap map, HttpServletRequest request);
    public ModelAndView view(ModelMap map);
    public ModelAndView delete1(@PathVariable() int id);
    public String edit1(ModelMap map, @PathVariable() int id);
    
    
}
