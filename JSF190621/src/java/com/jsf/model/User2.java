package com.jsf.model;

import com.jsf.util.Database2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class User2 {

    private int id;
    private String code;
    private String name;
    private int quantity;
    private Double price;
    private String categorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    
    
        public String save(){
        int result = 0;
        try{
            Connection connection = Database2.getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into products(code, name, quantity, price, categorie) values(?,?,?,?,?)");
            stmt.setString(1, code);
            stmt.setString(2, name);
            stmt.setInt(3, quantity);
            stmt.setDouble(4, price);
            stmt.setString(5, categorie);
            result = stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        if(result !=0)
            return "index2.xhtml?faces-redirect=true";
        else return "create2.xhtml?faces-redirect=true";
    }
    
}
