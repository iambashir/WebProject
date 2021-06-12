package com.java.servlet;

import java.sql.*;

public class GetCon {

    private GetCon() {
    }
    public static Connection con;

    static {
        try {
            Class.forName(DBIntializer.DRIVER);
            con = DriverManager.getConnection(DBIntializer.CON_STRING, DBIntializer.USERNAME, DBIntializer.PASSWORD);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            System.out.println("Exception in GetCon");
        }
    }

    public static Connection getCon() {
        return con;
    }
}
