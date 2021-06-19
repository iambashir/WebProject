package com.mtr.model;

import com.mtr.utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class Product {
    private int id, quantity;
    private double price;
    private String code, name, category;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    Connection con;
    private ArrayList productLists;

    public ArrayList productLists() {
        try {
            productLists = new ArrayList();
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));

                productLists.add(product);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productLists;
    }
    
    public void save(){
        try {
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into product (code, name, quantity, price, category) values(?,?,?,?,?)");
            ps.setString(1, code);
            ps.setString(2, name);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.setString(5, category);

            System.out.println(ps.executeUpdate());

            ps.close();
            con.close();
            //System.out.println(name + " " + email + " " + course + " " + area + " " + education[0]);
        } catch (Exception e) {
        } finally {
            clear();
        }
    }
    
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public String edit(int id){
        System.out.println("id is: " + id);
        Product product = null;
        try {
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from product where id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));
                System.out.println(product.getName() + " " + product.getPrice() + " " + product.getQuantity());
                sessionMap.put("editProduct", product);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return "/editProduct.xhtml?faces-redirect=true";
    }
    
    public String update(Product p){
        //int result = 0;
        try{
            con = Database.getConnection();  
            PreparedStatement stmt=con.prepareStatement("update product set code=?, name=?, quantity=?,price=?,category=? where id=?");  
            stmt.setString(1, p.getCode());  
            stmt.setString(2, p.getName());  
            stmt.setInt(3, p.getQuantity());  
            stmt.setDouble(4, p.getPrice());  
            stmt.setString(5, p.getCategory());  
            
            stmt.setInt(6, p.getId());
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println();
        }
        return "/product.xhtml?faces-redirect=true";      
    }
    
    public void delete(int id){
        try {
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from product where id=?");
            ps.setInt(1, id);
            System.out.println(ps.executeUpdate());
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void clear(){
        code = null;
        name = null;
        quantity = 0;
        price = 0;
        category = null;
    }
}
