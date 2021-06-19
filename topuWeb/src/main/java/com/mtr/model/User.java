package com.mtr.model;

import com.mtr.utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "user")
@RequestScoped
public class User {
    private int id;
    private String name, email, password, gender, address;

    Connection con;
    
    public User() {
    }

    public User(String name, String email, String password, String gender, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender + ", address=" + address + '}';
    }
    
    
    public void save(){
        try {
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into user (name, email, password, gender, address) values(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.setString(5, address);
            
            System.out.println(ps.executeUpdate());
            
            ps.close();
            con.close();
        } catch (Exception e) {
        }finally{
            clear();
        }
    }
    
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public String edit(int id){
        System.out.println("id is: " + id);
        User user = null;
        try {
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from user where id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                System.out.println(user.getName());
                sessionMap.put("editUser", user);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return "/edit.xhtml?faces-redirect=true";
    }
    
    public void delete(int id){
        try {
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from user where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }
    
    public String update(User u){
        //int result = 0;
        try{
            con = Database.getConnection();  
            PreparedStatement stmt=con.prepareStatement("update user set name=?,email=?,password=?,gender=?,address=? where id=?");  
            stmt.setString(1,u.getName());  
            stmt.setString(2,u.getEmail());  
            stmt.setString(3,u.getPassword());  
            stmt.setString(4,u.getGender());  
            stmt.setString(5,u.getAddress());  
            stmt.setInt(6,u.getId());  
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println();
        }
        return "/index.xhtml?faces-redirect=true";      
    }
    
    private void clear(){
        name = null;
        email = null;
        password = null;
        gender = null;
        address = null;
    }
}
