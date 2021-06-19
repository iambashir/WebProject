/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao.impl;

import com.spring.web.common.ICommonDAO;
import com.spring.web.model.User;

/**
 *
 * @author Asus
 */
public interface IUserDAO extends ICommonDAO<User> {
public User login(User user);
public User UserProfile(String code);
    
}
