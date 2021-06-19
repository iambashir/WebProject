package com.jsf.dao;

import com.jsf.model.User2;
import com.jsf.util.Database2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



@ManagedBean(name = "userDAO2")
public class UserDAO2 {

ArrayList usersList;
    Connection connection;
    public ArrayList usersList(){
        try{
            usersList = new ArrayList();
            connection = Database2.getConnection();
            Statement stmt= connection.createStatement();  
            String sql = "select * from products";
            ResultSet rs= stmt.executeQuery(sql);  
            while(rs.next()){
                User2 user = new User2();
                user.setId(rs.getInt("id"));
                user.setCode(rs.getString("code"));
                user.setName(rs.getString("name"));
                user.setQuantity(rs.getInt("quantity"));
                user.setPrice(rs.getDouble("price"));
                user.setCategorie(rs.getString("categorie"));
                
                usersList.add(user);
            }
            connection.close();        
        }catch(Exception e){
            System.out.println(e);
        }
        return usersList;
    }
    
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public String edit(String code){
        System.out.println("Front End ID  " + code);
        User2 user = null;
        try{
            connection = Database2.getConnection();
            Statement stmt= connection.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from products where code = "+(code));
            rs.next();
            user = new User2();
           // user.setCode(rs.getString("code"));
            user.setCode(rs.getString("code"));
            user.setName(rs.getString("name"));
            user.setQuantity(rs.getInt("quantity"));
            user.setPrice(rs.getDouble("price"));
            user.setCategorie(rs.getString("categorie")); 
            
            //System.out.println(rs.getString("password"));
            sessionMap.put("editUser2", user);
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }       
        return "/edit2.xhtml?faces-redirect=true";
    }
    
    
//    // Used to update user record
    public String update(User2 u){
        //int result = 0;
        try{
            connection = Database2.getConnection();  
            PreparedStatement stmt=connection.prepareStatement("update products set code=?, name=?, quantity=?, price=?, categorie=? where ocde=?");  
            stmt.setString(1,u.getCode());  
            stmt.setString(2,u.getName());  
            stmt.setInt(3,u.getQuantity());  
            stmt.setDouble(4,u.getPrice());  
            stmt.setString(5,u.getCategorie());  
            stmt.setString(6,u.getCode());  
            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println();
        }
        return "/index2.xhtml?faces-redirect=true";      
    }
//    // Used to delete user record
    public void delete(int id){
        try{
            connection = Database2.getConnection();  
            PreparedStatement stmt = connection.prepareStatement("delete from products where id = " +id);  
            stmt.executeUpdate();  
        }catch(Exception e){
            System.out.println(e);
        }
    }
   

}
