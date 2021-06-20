/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "user")
public class User {
    
   @Column(name = "id")
    @Id
    private int id;
   
   @Column(name = "firstname")
    private String firstname;
    
   @Column(name = "lastname")
    private String lastname;
   
   @Column(name = "username")
    private String username;
   
   @Column(name = "email")
    private String email;
   
   @Column(name = "password")
    private String password;
   
    @Column(name = "roleid")
    private String roleid;
    
    
    @Column(name = "roleid1")
    private String roleid1;
    
    
    @Column(name = "roleid2")
    private String roleid2;
    
    @Column(name = "mobile")
    private int mobile;
    
    @Column(name = "code")
    private String code;
    
    
//    @Column(name = "picture")
//    private byte[] picture;
    
    
//    private ByteArrayOutputStream img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
  
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoleid1() {
        return roleid1;
    }

    public void setRoleid1(String roleid1) {
        this.roleid1 = roleid1;
    }

    public String getRoleid2() {
        return roleid2;
    }

    public void setRoleid2(String roleid2) {
        this.roleid2 = roleid2;
    }
    
    

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    
    
    
    

//    public byte[] getPicture() {
//        return picture;
//    }
//
//    public void setPicture(byte[] picture) {
//        this.picture = picture;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
    
    
}
