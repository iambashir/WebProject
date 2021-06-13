/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.*;
/**
 *
 * @author User
 */
public class Database {
    public static Connection getConnection() {
        try  {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/jsptest",
                      "root","1234");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
    }
}
