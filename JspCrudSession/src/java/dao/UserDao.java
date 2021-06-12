/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Database;

/**
 *
 * @author User
 */
public class UserDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean doLogin(User user) {
        try {
            conn = Database.getConnection();
            String strQuery = "select * from login where username=? and  password=?";
            
            ps = conn.prepareStatement(strQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            System.out.println(strQuery);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            if(count>0){
            return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean doRegister(User user) {
        try {
            conn = Database.getConnection();
            String strQuery = "insert into login(username, password) values(?, ?)";
            
            ps = conn.prepareStatement(strQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            System.out.println(strQuery);
            int x = ps.executeUpdate();
            
            if(x>0){
            return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            conn = Database.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from login");
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("username"));
                user.setPass(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
