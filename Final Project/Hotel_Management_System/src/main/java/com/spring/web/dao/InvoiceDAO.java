/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao;

import com.spring.web.dao.impl.IInvoiceDAO;
import com.spring.web.model.AddService;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Invoice;
import com.spring.web.model.Invoice_total;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Repository
public class InvoiceDAO implements IInvoiceDAO {
    
    
     @Autowired
    SessionFactory sessionfactory;

    public SessionFactory getSessionfactory() {
        return sessionfactory;
    }

    public void setSessionfactory(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }
     
     
    
    @Transactional
    @Override
    public Invoice save(Invoice invoice) {
       sessionfactory.getCurrentSession().saveOrUpdate(invoice);
       sessionfactory.getCurrentSession().flush();
       return invoice;
    }

    
    @Transactional
    @Override
    public List<Invoice> getAll() {
       List<Invoice> invoiceList = sessionfactory.getCurrentSession().createCriteria(Invoice.class).list();
        sessionfactory.getCurrentSession().flush();
        return invoiceList;
    }

    @Override
    public Invoice update(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public Invoice delete(int id) {
        Invoice invoice = (Invoice) sessionfactory.getCurrentSession().load(Invoice.class, id);
        sessionfactory.getCurrentSession().delete(invoice);
        sessionfactory.getCurrentSession().flush();
        return invoice;
    }
    
    @Transactional
    @Override
    public Invoice getById(int id) {
         Invoice invoice = (Invoice) sessionfactory.getCurrentSession().get(Invoice.class, id);
         sessionfactory.getCurrentSession().flush();
         return invoice;
    }

    @Override
    public AddService geByDoctorCode(AddService service) {
       String sql = "from AddService where doctorcode = '"+service.getDoctorcode()+"'";
       List<AddService> s = getSessionfactory().openSession().createQuery(sql).list();
       return s.get(0);
    }

    @Transactional
    @Override
    public List<AppoinmentApprove> getAllApproveAppoinment() {
       List<AppoinmentApprove> AppoinApproveList = sessionfactory.getCurrentSession().createCriteria(AppoinmentApprove.class).list();
        sessionfactory.getCurrentSession().flush();
        return AppoinApproveList;
    }

    @Override
    public Invoice CreateInvoice(String invoiceId) {
        String invId =  invoiceId;
        System.out.println(invId+"from DAO---------");
        
        String sql = "from Invoice where id = '" + invId + "' ";
        List<Invoice> invoice = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(invoice.get(0).getDoctorname()+ " .....data");
        return invoice.get(0);
    }

    @Override
    public AddService getAllServiceName(String serviceCode) {
        String serCode =  serviceCode;
        System.out.println(serCode+"from DAO---------");
        
        String sql = "from AddService where servicecode = '" + serCode + "' ";
        List<AddService> service = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(service.get(0).getCategory()+ " .....data");
        return service.get(0);
    }

    @Transactional
    @Override
    public Invoice_total saveInvoiceWithTotalBill(Invoice_total itotal) {
       sessionfactory.getCurrentSession().saveOrUpdate(itotal);
       sessionfactory.getCurrentSession().flush();
       return itotal;
    }

    @Override
    public List<Invoice_total> getByInvoiceCode(String invoice_code) {
        String code =  invoice_code;
        System.out.println(code+"from DAO---------");
        
        String sql = "from Invoice_total where invoice_code = '" + code + "' ";
        List<Invoice_total> TinvoiceList = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(TinvoiceList.get(0).getId() + " .....data");
        return TinvoiceList;
    }

    @Override
    public Invoice_total getByIivCode(String InvCode) {
        String code =  InvCode;
        System.out.println(code+"from DAO---------");
        
        String sql = "from Invoice_total where invoice_code = '" + code + "' ";
        List<Invoice_total> invoice = getSessionfactory().openSession().createQuery(sql).list();
        System.out.println(invoice.get(0).getDoctorname()+ " .....data");
        return invoice.get(0);
    }
    
    
}
