
package com.jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Bashir Hosssain
 */
public class Database {

    private static Connection con;
   public static Connection getConnection() {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db1259855","root", "1234");
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       return con;
   }
}

