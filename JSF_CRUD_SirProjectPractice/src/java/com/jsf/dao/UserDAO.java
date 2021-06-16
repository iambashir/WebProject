package com.jsf.dao;

import com.jsf.model.User;
import com.jsf.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "userDAO")
public class UserDAO {
    ArrayList usersList;
    Connection connection;
    public ArrayList usersList(){
        try{
            usersList = new ArrayList();
            connection = Database.getConnection();
            Statement stmt= connection.createStatement();  
            String sql = "select * from users";
            ResultSet rs= stmt.executeQuery(sql);  
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                
                usersList.add(user);
            }
            connection.close();        
        }catch(Exception e){
            System.out.println(e);
        }
        return usersList;
    }
    
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public String edit(int id){
        System.out.println("Front End ID  " + id);
        User user = null;
        try{
            connection = Database.getConnection();
            Statement stmt= connection.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from users where id = "+(id));
            rs.next();
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setAddress(rs.getString("address"));
            user.setPassword(rs.getString("password"));  
            System.out.println(rs.getString("password"));
            sessionMap.put("editUser", user);
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }       
        return "/edit.xhtml?faces-redirect=true";
    }
//    // Used to update user record
    public String update(User u){
        //int result = 0;
        try{
            connection = Database.getConnection();  
            PreparedStatement stmt=connection.prepareStatement("update users set name=?,email=?,password=?,gender=?,address=? where id=?");  
            stmt.setString(1,u.getName());  
            stmt.setString(2,u.getEmail());  
            stmt.setString(3,u.getPassword());  
            stmt.setString(4,u.getGender());  
            stmt.setString(5,u.getAddress());  
            stmt.setInt(6,u.getId());  
            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println();
        }
        return "/index.xhtml?faces-redirect=true";      
    }
//    // Used to delete user record
    public void delete(int id){
        try{
            connection = Database.getConnection();  
            PreparedStatement stmt = connection.prepareStatement("delete from users where id = "+id);  
            stmt.executeUpdate();  
        }catch(Exception e){
            System.out.println(e);
        }
    }
    

}
