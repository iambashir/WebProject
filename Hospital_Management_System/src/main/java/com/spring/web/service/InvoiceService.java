/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service;

import com.spring.web.dao.impl.IAddServiceDAO;
import com.spring.web.dao.impl.IInvoiceDAO;
import com.spring.web.model.AddService;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Invoice;
import com.spring.web.model.Invoice_total;
import com.spring.web.service.impl.IInvoiceService;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class InvoiceService implements IInvoiceService{
    
    @Autowired
    IInvoiceDAO invoiceDAO;
//    IAddServiceDAO serviceDAO;
    

    @Override
    public void saveInvoice(HttpServletRequest request) {
         Map<String, String[]> map = request.getParameterMap();
        
        String firstname = map.get("firstname")[0];
        String lastname = map.get("lastname")[0];
        String mobile = map.get("mobile")[0];
        String address = map.get("address")[0];
        String email = map.get("email")[0];
        String gender = map.get("gender")[0];
        
        Date dateObject = new Date();
        String fronEndDateString = map.get("date")[0];
        
        String time = map.get("time")[0];
        String branch = map.get("branch")[0];
        String doctorname = map.get("doctorname")[0];
        String department = map.get("department")[0];
        String code = map.get("code")[0];

        

        String status = "1";




      AddService Service = new AddService();
      
      Service.setDoctorcode(code);
 
      AddService s = invoiceDAO.geByDoctorCode(Service);
      
      String servicename = s.getServicename();
      String servicecode = s.getServicecode();
      Double fee = s.getFee();
      
      String duration = s.getDuration();
      String category = s.getCategory();
      Double tax = s.getTax();

      System.out.println(s.getServicename()+"----Sname-----");
      System.out.println(s.getFee()+"----Sname-----");

        
        
        
        Invoice invoice = new Invoice();
        
        invoice.setFirstname(firstname);
        invoice.setLastname(lastname);
        invoice.setMobile(Integer.valueOf(map.get("mobile")[0]));
        invoice.setAddress(address);
        invoice.setEmail(email);
        invoice.setGender(gender);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        invoice.setDate(dateObject);
        invoice.setTime(time);
        invoice.setBranch(branch);
        invoice.setDoctorname(doctorname);
        invoice.setDepartment(department);
        invoice.setCode(code);
        
        invoice.setServicename(servicename);
        invoice.setServicecode(servicecode);
        invoice.setFee(fee);

        invoice.setDuration(duration);
        invoice.setCategory(category);
        invoice.setTax(tax);

       
        invoice.setStatus(status);
        
        
       invoiceDAO.save(invoice); 
    }
    
    
    @Override
    public Invoice save(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Invoice> getAll() {
        List<Invoice> invoiceList = invoiceDAO.getAll();
        return invoiceList;
    }

    @Override
    public Invoice update(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Invoice delete(int id) {
       Invoice invoice = invoiceDAO.delete(id);
        return invoice;
    }

    @Override
    public Invoice getById(int id) {
        Invoice invoice = invoiceDAO.getById(id);
        return invoice;
    }

    @Override
    public List<AppoinmentApprove> getAllApproveAppoinment() {
        List<AppoinmentApprove> AppoinApproveList = invoiceDAO.getAllApproveAppoinment();
        return AppoinApproveList;
    }

    @Override
    public Invoice CreateInvoice(String invoiceId) {
        
      return invoiceDAO.CreateInvoice(invoiceId);
    }
    

    @Override
    public AddService getAllServiceName(String serviceCode) {
       return invoiceDAO.getAllServiceName(serviceCode);
    }

    @Override
    public void saveInvoiceWithTotalBill(HttpServletRequest request) {
         Map<String, String[]> map = request.getParameterMap();
         
//         String[] firstname = (String[]) map.get("firstname[]");
//         String[] lastname = (String[]) map.get("lastname[]");
//         String[] doctorname = (String[]) map.get("doctorname[]");
//         String[] department = (String[]) map.get("department[]");
//         String[] branch = (String[]) map.get("branch[]");
         
         
         
         String[] category = (String[]) map.get("category[]");
         String[] servicename = (String[]) map.get("servicename[]");
         String[] fee = (String[]) map.get("fee[]");
         String[] tax = (String[]) map.get("tax[]");
         
//         String[] total_bill = (String[]) map.get("total_bill[]");
         
//         String[] invoice_code = (String[]) map.get("invoice_code[]");
         
         
         
          String firstname = map.get("firstname")[0];
          String lastname = map.get("lastname")[0];
          String doctorname = map.get("doctorname")[0];
          String department = map.get("department")[0];
          String branch = map.get("branch")[0];
//          String category = map.get("category[]")[0];
//          String servicename = map.get("servicename[]")[0];
//          String fee = map.get("fee[]")[0];
//          String tax = map.get("tax[]")[0];
//          
          String total_bill = map.get("currBill")[0];
//          
          String invoice_code = map.get("invoice_code")[0];
          
        

          
        for (int i = 0; i < category.length; i++) {
            
         Invoice_total Tinvoice = new Invoice_total();
         
         Tinvoice.setFirstname(firstname);
         Tinvoice.setLastname(lastname);
         Tinvoice.setDoctorname(doctorname);
         Tinvoice.setDate(new Date());
         Tinvoice.setTime(new Time(i));
         

         Tinvoice.setDepartment(department);
         Tinvoice.setDepartment(department);
         Tinvoice.setBranch(branch);
         Tinvoice.setCategory(category[i]);
         Tinvoice.setServicename(servicename[i]);
         Tinvoice.setFee(Double.parseDouble(map.get("fee[]")[i]));
         Tinvoice.setTax(Double.parseDouble(map.get("tax[]")[i]));
         
         Tinvoice.setTotal_bill(Double.parseDouble(map.get("currBill")[0]));
         
         Tinvoice.setInvoice_code(invoice_code);
         
         
         
         invoiceDAO.saveInvoiceWithTotalBill(Tinvoice);
        }
          
    }

    @Override
    public List<Invoice_total> getByInvoiceCode(String invoice_code) {
         List<Invoice_total> TinvoiceList = invoiceDAO.getByInvoiceCode(invoice_code);
        return TinvoiceList;
    }

    @Override
    public Invoice_total getByIivCode(String InvCode) {
        Invoice_total invoice = invoiceDAO.getByIivCode(InvCode);
        return invoice;
    }

    
    
}
