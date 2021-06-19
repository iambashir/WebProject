package com.spring.web.common;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


public interface ICommonController {
    public String create();
    public ModelAndView save(HttpServletRequest request);
    public ModelAndView edit(int id);
    public ModelAndView update(HttpServletRequest request);
    public ModelAndView getAll();
    public boolean delete(int id);
    public ModelAndView getById(int id);
}
