
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice</title>
        
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
        
        
         <link rel="stylesheet" href="/assets/test/styles.css" />
         
         <style>
             .invoiceHeader {

    font-family: Algerian;
    font-weight: bold;
    font-size: 32pt;
    color: darkcyan;
    background-color: #eaeaea;
    letter-spacing: 4pt;
    text-align: center;

}
         </style>
            
         
         
    </head>
    <body>

<div class="invoiceHeader">MEDICIO HOSPITAL</div>



<div class="container">
    <div class="row">
        <div class="col-xs-12">
    		<div class="invoice-title">
    			<h2>Invoice</h2><h4 class="pull-right">Invoice ID : ${invoice.invoice_code}</h4>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Billed To:</strong><br>
    					Abdul Karim<br>
    					${invoice.branch}<br>
    					01725689745<br>
    					
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
        			<strong>Patient Details:</strong><br>
    					${invoice.firstname} ${invoice.lastname}<br>
    					Madhabdi,Narsingdi<br>
                                        01818756942<br>
    					
    				</address>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    					<strong>Doctor Details:</strong><br>
    					${invoice.doctorname}<br>
    					${invoice.department}<br>
                                        01618756942
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
    					<strong>Date & Time :</strong><br>
                                          ${invoice.date} <br>
                                          11:30AM
<!--    					March 7, 2014<br><br>-->
    				</address>
    			</div>
    		</div>
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Bill details</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Service Name</strong></td>
        							<td class="text-center"><strong>Service Tax</strong></td>
        							<td class="text-center"><strong>Quantity</strong></td>
        							<td class="text-right"><strong>Service Fee</strong></td>
                                </tr>
    						</thead>
    						<tbody>
                                                    
                                                <c:forEach items="${TinvoiceList}" var="doc">
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
    								<td>${doc.servicename}</td>
    								<td class="text-center">${doc.tax}</td>
    								<td class="text-center">1</td>
    								<td class="text-right">${doc.fee}</td>
                                                                
                                                                
    							</tr>
                               
                               
            						
<!--    							<tr>
    								<td class="thick-line"></td>
    								<td class="thick-line"></td>
    								<td class="thick-line text-center"><strong>Subtotal</strong></td>
    								<td class="thick-line text-right">$670.99</td>
    							</tr>-->
                                                        
                                                        
                                                        <!--
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Shipping</strong></td>
    								<td class="no-line text-right">$15</td>
    							</tr>
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Total</strong></td>
    								<td class="no-line text-right">$1500.00</td>
    							</tr>-->



                                                        </c:forEach>
                                                        <tr>
    								<td class="thick-line"></td>
    								<td class="thick-line"></td>
    								<td class="thick-line text-center"><strong>Subtotal</strong></td>
    								<td class="thick-line text-right">${invoice.total_bill}</td>
    							</tr>
                                                        
                                                        <tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Total</strong></td>
    								<td class="no-line text-right">${invoice.total_bill}</td>
    							</tr>
    						</tbody>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</div>
                                                        
                               
                        <div style="text-align: center">
                            <button class="btn btn-primary" onclick="window.print()">Print this Invoice</button>
                        </div>
                                                        
                        <br>  
                        <br>
                                
        
        </body>
</html>