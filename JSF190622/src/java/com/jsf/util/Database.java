/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Hiccup
 */
public class Database {

    private static Connection con;
   public static Connection getConnection() {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shop","root", "1234");
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       return con;
   }
}

