/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.web.dao.impl;

import com.spring.web.common.ICommonDAO;
import com.spring.web.model.AddService;
import com.spring.web.model.AppoinmentApprove;
import com.spring.web.model.Invoice;
import com.spring.web.model.Invoice_total;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IInvoiceDAO extends ICommonDAO<Invoice> {
  public AddService geByDoctorCode(AddService service); 
  public List<AppoinmentApprove> getAllApproveAppoinment();
  public Invoice CreateInvoice(String invoiceId);
  public AddService getAllServiceName(String serviceCode);
  public Invoice_total saveInvoiceWithTotalBill(Invoice_total itotal);
  public List<Invoice_total> getByInvoiceCode(String invoice_code);
  public Invoice_total getByIivCode(String InvCode);
}
