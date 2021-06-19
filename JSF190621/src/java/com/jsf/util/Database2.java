package com.jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database2 {
public static Connection getConnection() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shop","root", "1234");
        return con;
    } catch (Exception ex) {
        System.out.println("Database.getConnection() Error -->" + ex.getMessage());
        return null;
    }
}
}
