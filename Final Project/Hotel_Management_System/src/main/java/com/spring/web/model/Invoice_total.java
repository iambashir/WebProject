/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.model;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */

@Entity
@Table(name = "invoice_total")
public class Invoice_total {
    
    @Column(name = "id")
    @Id
    private int id; 
    
    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "doctorname")
    private String doctorname;
    
    @Column(name = "date")
    private Date date;
     
    @Column(name = "department")
    private String department;
      
    @Column(name = "branch")
    private String branch;
       
    @Column(name = "category")
    private String category;
       
    @Column(name = "servicename")
    private String servicename;
       
    @Column(name = "fee")
    private double fee;
       
    @Column(name = "tax")
    private double tax;
    
    @Column(name = "total_bill")
    private double total_bill;
    
    @Column(name = "invoice_code")
    private String invoice_code;
    
    @Column(name = "time")
    private Time time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(double total_bill) {
        this.total_bill = total_bill;
    }

    public String getInvoice_code() {
        return invoice_code;
    }

    public void setInvoice_code(String invoice_code) {
        this.invoice_code = invoice_code;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    
    
    
    
    
    
}
