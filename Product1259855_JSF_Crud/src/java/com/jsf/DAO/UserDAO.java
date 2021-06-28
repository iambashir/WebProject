/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.DAO;

import com.jsf.model.Product;
import com.jsf.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bashir Hossain
 */
@ManagedBean(name ="userDAO")
public class UserDAO {
    ArrayList usersList;
    Connection connection;
    public ArrayList usersList(){
        try {
            usersList = new ArrayList();
            connection = Database.getConnection();
            PreparedStatement stmt =connection.prepareStatement("select * from product");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Product pdt = new Product();
                pdt.setId(rs.getInt("id"));
                pdt.setCode(rs.getString("code"));
                pdt.setName(rs.getString("name"));
                pdt.setQuantity(rs.getInt("quantity"));
                pdt.setPrice(rs.getDouble("price"));
                pdt.setCategory(rs.getString("category"));
                usersList.add(pdt);
                //System.out.println(pdt.getName());
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
   // private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public String edit(int id){
        //System.out.println("Front End ID  " + id);
        Product pdt = null;
        try {
            connection= Database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from product where id = "+(id));
            rs.next();
                pdt = new Product();
                pdt.setId(rs.getInt("id"));
                pdt.setCode(rs.getString("code"));
                pdt.setName(rs.getString("name"));
                pdt.setQuantity(rs.getInt("quantity"));
                pdt.setPrice(rs.getDouble("price"));
                pdt.setCategory(rs.getString("category"));
             
               // System.out.println(rs.getString("code"));
                sessionMap.put("editProd", pdt);
               
                //connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return"/edit.xhtml?faces-redirect=true";
    }
    public String update(Product p){
        
        try{
            connection = Database.getConnection();  
            PreparedStatement stmt=connection.prepareStatement("update product set code=?, name=?,quantity=?,price=?, category=? where id=?");  
            stmt.setString(1, p.getCode());
            stmt.setString(2, p.getName());  
            stmt.setInt(3, p.getQuantity());  
            stmt.setDouble(4, p.getPrice());  
            stmt.setString(5, p.getCategory());    
            stmt.setInt(6,    p.getId());  
            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return "/index.xhtml?faces-redirect=true";      
    }
    public void delete(int id){
        try{
            connection = Database.getConnection();  
            PreparedStatement stmt = connection.prepareStatement("delete from product where id = "+id);  
            stmt.executeUpdate();  
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
