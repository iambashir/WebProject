/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.web.controller.impl.IInvoiceController;
import com.spring.web.model.AddService;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Invoice;
import com.spring.web.model.Invoice_total;
import com.spring.web.service.impl.IAddServiceService;
import com.spring.web.service.impl.IInvoiceService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Asus
 */

@RestController
@RequestMapping(value="/invoice")
public class InvoiceController implements IInvoiceController {
    
    
    @Autowired
    IInvoiceService invoiceService;
    
     @Autowired
    IAddServiceService addService;

   
    @RequestMapping(value = "/create")
    public ModelAndView create1(ModelMap map) {
        
     List<Invoice> Paitents = invoiceService.getAll();    
     map.addAttribute("Paitents", Paitents);  
     
     List<AddService> services = addService.getAll();    
     map.addAttribute("services", services); 
        
        
        
//    List<AppoinmentApprove> Paitents = invoiceService.getAllApproveAppoinment();    
//    map.addAttribute("Paitents", Paitents);   
//        for (int i = 0; i < Paitents.size(); i++) {
//            System.out.println(Paitents.get(i).getFirstname() + "   ....");
//        }
        return new ModelAndView("Invoice/CreateInvoice");
    }
    
    
    
    @RequestMapping(value = "/createFromReceptionist")
    public ModelAndView createInvoice(ModelMap map) {
        
     List<Invoice> Paitents = invoiceService.getAll();    
     map.addAttribute("Paitents", Paitents);  
     
     List<AddService> services = addService.getAll();    
     map.addAttribute("services", services); 
        
        
        

        return new ModelAndView("recep/CreateInvoice");
    }
    
    
    
    
//    @RequestMapping(value = "/create1")
//    public ModelAndView getAllServices(ModelMap map) {
//        
//     List<AddService> services = addService.getAll();    
//     map.addAttribute("services", services); 
//    
//     return new ModelAndView("Invoice/CreateInvoice");
//    }
    
    

    @Override
    @RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
         invoiceService.saveInvoice(request);
         
         System.out.println("hit by saveInvoice");
         
         return new ModelAndView("redirect:/doctor");
    }
    
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(ModelMap map){
    List<Invoice> invoiceList = invoiceService.getAll();
    map.addAttribute("invoiceList", invoiceList);
    System.out.println("InvoiceList for admin");

    
    return new ModelAndView("Invoice/InvoiceList");

    }
    
    
    
   @RequestMapping(value = "/InvoiceListforReceptionist", method = RequestMethod.GET)
    public ModelAndView InvoiceListForReceptionist(ModelMap map){
    List<Invoice> invoiceList = invoiceService.getAll();
    map.addAttribute("invoiceList", invoiceList);
    System.out.println("InvoiceList");

    
    return new ModelAndView("recep/InvoiceListForReceptionist");

    }
    
    
    
    

    @Override
    public ModelAndView edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletefromAdmin(@PathVariable("id") int id){
        invoiceService.delete(id);
//       empDAO.delete(112);
       System.out.println("hit by delete");
//        return "redirect:/doctor/view";
        return new ModelAndView("redirect:/invoice/view");
    }
    
    
     @RequestMapping(value = "/deleteFromReceptionist/{id}", method = RequestMethod.GET)
    public ModelAndView deletefromReceptionist(@PathVariable("id") int id){
        invoiceService.delete(id);
//       empDAO.delete(112);
       System.out.println("hit by delete");
//        return "redirect:/doctor/view";
        return new ModelAndView("redirect:/invoice/InvoiceListforReceptionist");
    }

    @Override
    public ModelAndView getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //  -----------------  Make invoice with doctor visit only  ------------------------
            
            
    @RequestMapping(value = "/makeInvoice/{id}", method = RequestMethod.GET)
    public ModelAndView Makeinvoice(ModelMap map, @PathVariable("id") int id){
         
        Invoice invoice = invoiceService.getById(id);
        map.addAttribute("invoice", invoice);
         System.out.println(invoice.getDoctorname()+ "   print");

        return new ModelAndView("/Invoice/Invoice");
    }
    
    
    
    
    @RequestMapping(value = "/createInvoice", method = RequestMethod.POST, produces = "application/json")
    public String CreateInvoice(ModelMap map, HttpServletRequest request){
        
     Map<String, String[]> model = request.getParameterMap();
     String invoiceId = model.get("invoice_id")[0];
        System.out.println(invoiceId + " ..............id");
     Invoice invoice = invoiceService.CreateInvoice(invoiceId);
         
         GsonBuilder gson = new GsonBuilder();
         Gson g = gson.create();
//         Gson h = gson.create();
    
        return g.toJson(invoice); 
    }
    
    
    
    @RequestMapping(value = "/GetAllServiceName", method = RequestMethod.POST, produces = "application/json")
    public String getAllServiceName(ModelMap map, HttpServletRequest request){
        
     Map<String, String[]> model = request.getParameterMap();
     String serviceCode = model.get("service_code")[0];
        System.out.println(serviceCode + " ..............Code");
     AddService service = invoiceService.getAllServiceName(serviceCode);
         
         GsonBuilder gson = new GsonBuilder();
         Gson g = gson.create();
//         Gson h = gson.create();
    
        return g.toJson(service); 
    }
    
    
    
    
    
    

    @Override
    public String create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
     @RequestMapping(value = "/saveInvoiceWithTotalBill", method = RequestMethod.POST)
    public ModelAndView saveInvoiceWithTotalBill(ModelMap map, HttpServletRequest request) {
        Map<String, String[]> model = request.getParameterMap();
        
         String currBill = model.get("currBill")[0];
         System.out.println(currBill+".....Bill........");

         String invoice_code = model.get("invoice_code")[0];
        
        
         invoiceService.saveInvoiceWithTotalBill(request);

           
         List<Invoice_total> TinvoiceList = invoiceService.getByInvoiceCode(invoice_code);
         map.addAttribute("TinvoiceList", TinvoiceList);
         
//         for (int i = 0; i < TinvoiceList.size(); i++) {
//            System.out.println(TinvoiceList.get(i).getFirstname() + "   ....");
//        }
         
         Invoice_total invoice = invoiceService.getByIivCode(invoice_code);
         map.addAttribute("invoice", invoice);

         return new ModelAndView("Invoice/Invoice_total");
    }
    
    
    
}
