/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service;

import com.spring.web.dao.impl.IUserDAO;
import com.spring.web.model.User;
import com.spring.web.service.impl.IUserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
@Service
public class UserService implements IUserService {
    
    @Autowired
    IUserDAO uDAO;
    
     @Override
    public Map<String, Object> save(HttpServletRequest request, MultipartFile file) {
         Map<String, String[]> map = request.getParameterMap();
         
//                 file.
         
        
                
//                     For Message 
       
        Map<String, Object> obj = new HashMap<String, Object>();
          obj.put("success", "Congratulations, User Saved !!!");
         
         
         
         
        String firstname = map.get("firstname")[0];
        String lastname = map.get("lastname")[0];
        String username = map.get("username")[0];
        String email = map.get("email")[0];
        String password = map.get("password")[0];
        String roleid = "1";
        String mobile = map.get("mobile")[0];
         String code = map.get("code")[0];
        
        
        
        

        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleid(roleid);
        user.setMobile(Integer.valueOf(map.get("mobile")[0]));
        
         user.setCode(code);
        
        uDAO.save(user);
        
         return obj;
    }
    

    
     @Override
    public User login(User user) {
       // User u = uDAO.login(user);
        return uDAO.login(user);
    }
    
    


    @Override
    public User save(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() {
       List<User> userList = uDAO.getAll();
        return userList;
    }

    @Override
    public User update(User user) {
        uDAO.update(user);
        return user;
    }

    @Override
    public User delete(int id) {
        User user = uDAO.delete(id);
        return user;
    }

    @Override
    public User getById(int id) {
        User user = uDAO.getById(id);
        return user;
    }

//    @Override
//    public Map<String, Object> save(HttpServletRequest request, MultipartFile file) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public User UserProfile(String code) {
         User u = uDAO.UserProfile(code);
         return u;
    }

   

    

   


}
