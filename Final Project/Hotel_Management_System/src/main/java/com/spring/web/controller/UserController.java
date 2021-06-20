/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;

import com.spring.web.controller.impl.IUserController;
import com.spring.web.model.Doctor;
import com.spring.web.model.User;
import com.spring.web.service.impl.IUserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */
@Controller
@RequestMapping(value = "/user")
public class UserController implements IUserController {

    @Autowired
    IUserService uService;

    @RequestMapping(value = "/create")
    public String create() {
        System.out.println("Hello create");
        return "user/create";
    }
    
   

    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("Login User");
        return "user/logform";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request, MultipartFile file) {
//        uService.save(request);

        
        
        Map<String, Object> map = uService.save(request, file);
        return new ModelAndView("user/create", "map", map);
        
        
//        return new ModelAndView("user/create");
    }

//     @RequestMapping(value = "/loginaction", method = RequestMethod.POST)
//     @Override
//    public ModelAndView loginAction(ModelMap map, HttpServletRequest request) {
//     Map<String, String[]> model = request.getParameterMap();
//     
//     boolean action = uService.login(request);
//     if(action) {
////         map.addAttribute("username", model.get("username")[0]);
//         return new ModelAndView("admin/adminpanel");
//     }else
//         return new ModelAndView("user/404");
//    }
    
    
    
    @RequestMapping(value = "/loginaction", method = RequestMethod.POST)
    @Override
    public ModelAndView loginAction(ModelMap map, HttpServletRequest request) {
        Map<String, String[]> model = request.getParameterMap();

//        String id = model.get("id")[0];

        String username = model.get("username")[0];
        String password = model.get("password")[0];
        
        String roleid = "1";
        String roleid1 = "2";
        String roleid2 = "3";
        
        User user = new User();
        
//        user.setId(id);

        user.setUsername(username);
        user.setPassword(password);
        user.setRoleid(roleid);
        user.setRoleid(roleid1);
        user.setRoleid(roleid2);
        
        User u = uService.login(user);
//             u.getId();
        

        if (username.equals(u.getUsername()) && password.equals(u.getPassword()) && roleid.equals(u.getRoleid())) {
            map.addAttribute("user", u);
           // map.addAttribute("username", model.get("username")[0]);
            //map.addAttribute("password", model.get("password")[0]);
//            map.addAttribute("id", model.get("id")[0]);
           
           return new ModelAndView("admin/adminpanel");
           
           } else if(username.equals(u.getUsername()) && password.equals(u.getPassword()) && roleid1.equals(u.getRoleid())){
               
            //map.addAttribute("username", model.get("username")[0]);
            //map.addAttribute("password", model.get("password")[0]);  
             map.addAttribute("user", u);  
           return new ModelAndView("doctor/doctorpanel"); 
           
           } else if(username.equals(u.getUsername()) && password.equals(u.getPassword()) && roleid2.equals(u.getRoleid())){
                map.addAttribute("user", u);
           return new ModelAndView("recep/Receptionistpanel");
           
         } else {
            return new ModelAndView("user/404");
        }
    }
    
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(ModelMap map) {
        
     List<User> userList = uService.getAll();
     map.addAttribute("userList", userList);
        return new ModelAndView("user/uview");
    }

    @Override
    public ModelAndView edit(int id) {
        return null;
    }
    
     @Override
     @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
     public String edit1(ModelMap map, @PathVariable("id") int id) {
         
         User user = uService.getById(id);
        map.addAttribute("doc", user);
         System.out.println(user.getUsername() + "   print");

        return "/user/Uedit";
        
    }
     
     @RequestMapping(value = "/update", method = RequestMethod.POST)
     public String update1(ModelMap map, @ModelAttribute("user") User user) {
        
        User u = uService.update(user);
        
        System.out.println("hit by update");
        System.out.println(u.getLastname());
        
        return "redirect:/user/view";
//       
    }
     

    @Override
    public ModelAndView update(HttpServletRequest request) {
        return null;
    }

    @Override
    public ModelAndView getAll() {
        return null;
    }
    
    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete1(@PathVariable("id") int id) {
        uService.delete(id);
//       empDAO.delete(112);
//       System.out.println("hit user by delete");

        return new ModelAndView("redirect:/user/view");
    }
    

    @Override
    public boolean delete(@PathVariable("id") int id) {
        
        
        return true;
    }

    @Override
    public ModelAndView getById(int id) {
        return null;
    }

    @Override
    public ModelAndView save(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     @RequestMapping(value = "/adminProfile")
    public String Profile() {
        System.out.println("Hello Profile");
        return "admin/AdminProfile";
    }
    
    
    
    
    @RequestMapping(value="/adminProfile/{code}",  method = RequestMethod.GET)
    public ModelAndView UserProfile(ModelMap map, @PathVariable("code") String code) {
      User u = uService.UserProfile(code);
      map.addAttribute("u", u);
    return new ModelAndView("/admin/AdminProfile");
    }
    

   

    

}
