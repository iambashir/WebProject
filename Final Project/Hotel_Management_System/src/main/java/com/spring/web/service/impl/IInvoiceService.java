/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.service.impl;

import com.spring.web.common.ICommonService;
import com.spring.web.model.AddService;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Invoice;
import com.spring.web.model.Invoice_total;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Asus
 */
public interface IInvoiceService extends ICommonService<Invoice>{
    public void saveInvoice(HttpServletRequest request);
    public List<AppoinmentApprove> getAllApproveAppoinment();
    public Invoice CreateInvoice(String invoiceId);
    public AddService getAllServiceName(String serviceCode);
    public void saveInvoiceWithTotalBill(HttpServletRequest request);
    public List<Invoice_total> getByInvoiceCode(String invoice_code);
    
    public Invoice_total getByIivCode(String InvCode);
}
