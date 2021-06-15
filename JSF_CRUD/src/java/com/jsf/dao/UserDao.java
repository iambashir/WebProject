package com.jsf.dao;

import com.jsf.model.User;
import com.jsf.util.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "userDao")
public class UserDao {
private ArrayList userList;
Connection con;
 public ArrayList userList() {
       try {
           userList = new ArrayList();
           con = Database.getConnection();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from users");
           while (rs.next()) {
               User u = new User();
               u.setId(rs.getInt("id"));
               u.setName(rs.getString("name"));
               u.setEmail(rs.getString("email"));
               u.setPassword(rs.getString("password"));
               u.setGender(rs.getString("gender"));
               u.setAddress(rs.getString("address"));
               userList.add(u);
           }
           con.close();
       } catch (Exception e) {
           System.out.println(e);
       }
       return userList;
   }
}


