package com.jsf.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;

public class Database {
private static Connection con;
public static Connection getConnection(){

  try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "1234");
           return con;
        } catch (Exception e) {
           System.out.println("Database.getConnection() Error-->" + e.getMessage());
           return null;
       }

   }
    
    
}


