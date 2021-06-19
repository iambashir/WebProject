<%-- 
    Document   : CreateInvoice
    Created on : Aug 31, 2020, 9:57:34 AM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Invoice</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="/assets/test/styles.css" />

        <!--         W3School Success icon-->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!--         for delete-->
        <script src='https://kit.fontawesome.com/a076d05399.js'></script> 

        <!--                medical icon-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            hr.new1 {
  border-top: 2px solid #b6b6b6;
}



hr.new3 {
  border-top: 2px dotted black;
}

  

        </style>

    </head>
    <body>

        <%@include file="/assets/test/header.html"%>


        <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
<!--      <a class="navbar-brand" href="#">Hospital Management System</a>-->
      <a class="navbar-brand" href="#">Welcome to Admin Panel</a>
      <a href="/index"><i class="fa fa-plus-square" style="font-size:48px;color:red"></i></a> 
    </div>
      
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="/admin">Home</a></li>
      <li><a href="/user/adminProfile/${user.code}">Profile</a></li>
      <li><a href="/Audit/view">Audit Log</a></li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">User<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/user/create">Add User</a></li>
          <li><a href="/user/view">User List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Doctor<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/doctor/create">Add Doctor</a></li>
          <li><a href="/doctor/view">Doctor List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Add Patient</a></li>
          <li><a href="/appoin/PatientList">Patient List</a></li>
        </ul>
      </li>
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Receptionist<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/rec/create">Add Receptionist</a></li>
          <li><a href="/rec/view">Receptionist List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Appointment<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/appoin/create">Make Appointment</a></li>
          <li><a href="/appoin/view">Appointment List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Service<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/addService/create">Add Service</a></li>
          <li><a href="/addService/view">Service List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Invoice<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/invoice/create">Create Invoice</a></li>
          <li><a href="/invoice/view">Doctor done Patient List</a></li>
        </ul>
      </li>
      
      
      <li><a href="/user/login">Logout</a></li>
      
    </ul>
         
  </div>
</nav>
<!--            End nav-->


            <div style="text-align: center"> <h1 style="color: darkolivegreen">Create Invoice</h1> </div>
       

        <div class="row">
            <div class="col-md-12">
                
                
                
                <form action="/invoice/saveInvoiceWithTotalBill" method="post">
               
                
                  <div class="row">
                      <div class="col-md-12">

                          <div class="col-md-6">
                              
                              <div class="form-group col-md-9 mb-3" style="color: #008CBA">
                    <label for="patientname">Doctor done Patient Name : </label>
                    <select class="form-control" id="patientname" name="patientname">

                        <c:forEach items="${Paitents}" var="Patient">
                            <option value="${Patient.id}">${Patient.firstname} ${Patient.lastname}</option>
                        </c:forEach> 

                    </select>
                    <input type="hidden" name="invoice_id" id="invoice_id"/>
                    <br>
                     <input type="text" class="form-control" name="invoice_code" placeholder="Enter an Invoice Code"/>

                </div>

                <br>

                <a href="#" style="color: blue" id="showPatient">
                <i class='fas fa-check-circle' style='font-size:35px;color:green'></i></a>
                
                          </div>  
                          
                          <div class="col-md-1"></div>
                          <div class="col-md-5">
                              
                              <!--     =========           All Service Name   ===========-->
                
                
                 <div class="form-group col-md-11 mb-3" style="color: #008CBA">
                    <label for="servicename">Add more Service</label>
                    <select class="form-control" id="servicename" name="servicename">

                        <c:forEach items="${services}" var="service">
                            <option value="${service.servicecode}">${service.servicename}</option>
                        </c:forEach> 

                    </select>
                    <input type="hidden" name="service_code" id="service_code"/>

                </div>

                <br>

                <a href="#" style="color: blue" id="showService">
                <i class='fas fa-check-circle' style='font-size:35px;color:green'></i></a>

                                
                              
                          </div>
                         
                  </div>
                       </div>



                
                
                

                <div class="row">
                    <div class="col-md-12"> 

                        <div class="col-md-12">


                            <span></span><br>
                            
                            




                            <div style="text-align: center">
                                <h3 style="color: #008CBA">Patient detail with used Services</h3>

                                
                                    
                                <table class="table table-hover" id="myTable">
                                    <thead>
                                        <tr>
                                            <th style="color: #0056b3">First Name</th>
                                            <th style="color: #0056b3">Last Name</th>
                                            <th style="color: #0056b3">Doctor Name</th>
                                            
                                            
<!--                                            <th style="color: #0056b3">Email</th>
                                            <th style="color: #0056b3">Address</th>
                                            <th style="color: #0056b3">Mobile Number</th>
                                            <th style="color: #0056b3">Gender</th>-->
                                            
                                            <th style="color: #0056b3">Date</th>
                                            <th style="color: #0056b3">Department</th>
                                            <th style="color: #0056b3">Branch</th>

                                            <th style="color: #0056b3">Service Category</th>
                                            <th style="color: #0056b3">Service Name</th>
                                            <th style="color: #0056b3">Service Fee</th>
                                            <th style="color: #0056b3">Service Tax</th>
                                           


                                           
                                        </tr>
                                        
                                        
                                   
                                    </thead>

                                    <tbody>
                  
                                    </tbody>
                                </table>
                                    
                                    
                                    
                                    <input type="hidden" name="currBill" value="" id="currBill"/>
                                    
                                    
                            
                                            
                                                   
                                  <div style="text-align: center">
                                    <hr class="new1">
                                     </div>
                                    
                                    <h3 style="text-align: right">Total  bill = <label id="totalBill"></label> /= </h3>
                                    
                                                   
                                                  
                                                   
                                                   <div style="text-align: center">
                                                       
                                                        
                                                   
                                                    <input type="submit" class="btn btn-success" value="Submit Invoice">
                                                     </div>         
        
        
                                                          </form>

                               
                                    
                               

                            </div>


                        </div>

                    </div>
                </div>   


















                <br>
                   
               
                </div>
                     </div>




            
<!--                ++++++++             Create one row for one click use javaScript-++++++++++++++++++++->-->
                    
                    
                    
<!--                
                 <div style="text-align: center">
                    <input type="button" class="btn btn-info btn-lg" id="btnAdd" value="Add more Service"/>
                    
                   


                <br>
                <table class="table table-hover" id="tbl">
                    <thead>
                        <tr>

                            <th style="color: #0056b3">Service Code</th>
                            <th style="color: #0056b3">Service Name</th>

                        </tr>
                    </thead>


                    <tbody>
                        <tr>
                            <td>
                                <select class="form-control" id="department" name="department">

                                    <option value="Orthopedics">Medicine</option>
                                    <option value="Cardiology">Cardiology</option>
                                    <option value="Surgery">Surgery</option>



                                </select>
                            </td>
                            <td>Doctor Visit</td>
                        </tr>

                    </tbody>
                </table>

           -->

      
                                        




       
        
<!--                                                 <form action="/invoice/saveInvoiceWithTotalBill" method="post">
        
                                                <input type="hidden" name="firstname" value="data.firstname"/>
                                                <input type="hidden" name="lastname" value="data.lastname"/>
                                                <input type="hidden" name="doctorname" value="data.doctorname"/>
                                                <input type="hidden" name="date" value="data.date"/>
                                                <input type="hidden" name="department" value="data.department"/>
                                                <input type="hidden" name="branch" value="data.branch"/>
                                                <input type="hidden" name="category" value="data.category"/>
                                                <input type="hidden" name="servicename" value="data.servicename"/>
                                                <input type="hidden" name="fee" value="data.fee"/>
                                                <input type="hidden" name="tax" value="data.tax"/>
                                                

-->           



        
        
 <script>
            $("#btnAdd").click(function () {
                var html = '<tr><td><select class="form-control" id="department" name="department">'

//                                     +'<option value="Orthopedics">Medicine</option>'
//                                    +'<option value="Cardiology">Cardiology</option>'
//                                    +'<option value="Surgery">Surgery</option>'
                        + '<c:forEach items="${services}" var="service">'
                        + '<option value="${service.servicecode}">${service.servicename}</option>'
                        + '</c:forEach>'


                        + '</select></td><td>Ambulance Service</td></tr>';
                $("#tbl tbody").append(html);
            });



//                 ----For pataient---------


            $("#invoice_id").val($("#patientname option:selected").val());

            $("#patientname").on("change", function () {
                $("#invoice_id").val($("#patientname option:selected").val());
            });

            $("#showPatient").click(function () {
                console.log($("#invoice_id").val());

                $.post("/invoice/createInvoice",{
                            invoice_id: $("#invoice_id").val(),
                            dataType : 'json',
                        },function (data, status) {
                           
                          
                            var html =  '<tr>'
                                              +'  <td style="color: #777777">'+data.firstname+'</td>'
                                              +'  <td style="color: #777777">'+data.lastname+'</td>'
                                              +'  <td style="color: #777777">'+data.doctorname+'</td>'
                                      
                                      
//                                              +'  <td style="color: #777777">'+data.email+'</td>'
//                                              +'  <td style="color: #777777">'+data.address+'</td>'
//                                              +'<td style="color: #777777">'+data.mobile+'</td>'
//                                              +' <td style="color: #777777">'+data.gender+'</td>'

                                      
                                              +'<td style="color: #777777">'+data.date+'</td>'
                                              +'<td style="color: #777777">'+data.department+'</td>'
                                              +'<td style="color: #777777">'+data.branch+'</td>'
                                              +'<td style="color: #777777">'+data.category+'</td>'
                                              +'<td style="color: #777777">'+data.servicename+'</td>'
                                              +'<td style="color: #777777">'+data.fee+'</td>'
                                              +'<td style="color: #777777">'+data.tax+'</td>'
                                      
                                      
                                              +'<td style="color: #777777">'
                                              
                                              +' <input type="hidden" name="firstname" value="'+data.firstname+'"/>'
                                              +' <input type="hidden" name="lastname" value="'+data.lastname+'"/>'
                                              +' <input type="hidden" name="doctorname" value="'+data.doctorname+'"/>'
                                              +' <input type="hidden" name="date" value="'+data.date+'"/>'
                                              +' <input type="hidden" name="department" value="'+data.department+'"/>'
                                              +' <input type="hidden" name="branch" value="'+data.branch+'"/>'
                                              +' <input type="hidden" name="category[]" value="'+data.category+'"/>'
                                              +' <input type="hidden" name="servicename[]" value="'+data.servicename+'"/>'
                                              +' <input type="hidden" name="fee[]" value="'+data.fee+'"/>'
                                              +' <input type="hidden" name="tax[]" value="'+data.tax+'"/>'
                                              
                                      
                                              
                                              +'</td>';
                                       
//                                            +'<td style="color: #777777">Doctor visit</td>'

                                               
                                            +'</tr>';

                                           $("#myTable tbody").append(html);
                                           
                                            var val = $("#totalBill").text();
                                           console.log(val);
                                           var currBill = parseInt(val);
                                           var subTotal = data.fee + data.tax;                                               
                                           if(currBill> 0){
                                                $("#totalBill").text(currBill+subTotal);
                                                console.log($("#totalBill").text());
                                                $("#currBill").val($("#totalBill").text());
                                           }else{
                                               
                                                $("#totalBill").text(subTotal);
                                                console.log($("#totalBill").text());
                                                $("#currBill").val($("#totalBill").text());
                                           }
                        });

            });
            
            
//                   ------------- Get for Service   ------------------------
            
            
            
            $("#service_code").val($("#servicename option:selected").val());

            $("#servicename").on("change", function () {
                $("#service_code").val($("#servicename option:selected").val());
            });
            

            $("#showService").click(function () {
                console.log($("#service_code").val());
                
                 $.post("/invoice/GetAllServiceName",{
                            service_code: $("#service_code").val(),
                            dataType : 'json',
                        },function (data, status) {
                           
                          
                            var html =  '<tr>'
                                              +'  <td style="color: #777777"></td>'
                                              +'  <td style="color: #777777"></td>'
                                              +'  <td style="color: #777777"></td>'
                                      
                                      
//                                              +'  <td style="color: #777777">'+data.email+'</td>'
//                                              +'  <td style="color: #777777">'+data.address+'</td>'
//                                              +'<td style="color: #777777">'+data.mobile+'</td>'
//                                              +' <td style="color: #777777">'+data.gender+'</td>'

                                      
                                              +'<td style="color: #777777"></td>'
                                              +'<td style="color: #777777"></td>'
                                              +'<td style="color: #777777"></td>'
                                              +'<td style="color: #777777">'+data.category+'</td>'
                                              +'<td style="color: #777777">'+data.servicename+'</td>'
                                              +'<td style="color: #777777">'+data.fee+'</td>'
                                              +'<td style="color: #777777">'+data.tax+'</td>'
                                              
                                              +'<td style="color: #777777">'
                                              +' <input type="hidden" name="category[]" value="'+data.category+'"/>'
                                              +' <input type="hidden" name="servicename[]" value="'+data.servicename+'"/>'
                                              +' <input type="hidden" name="fee[]" value="'+data.fee+'"/>'
                                              +' <input type="hidden" name="tax[]" value="'+data.tax+'"/>'
//                                              +' <input type="hidden" name="currBill" value="'+currBill+'"/>'
                                              +'</td>';
                                              
                                       
//                                            +'<td style="color: #777777">Doctor visit</td>'

                                               
                                            +'</tr>';

                                           $("#myTable tbody").append(html);
                                           var val = $("#totalBill").text();
                                           console.log(val);
                                           var currBill = parseInt(val);
                                           console.log(currBill);
                                           var subTotal = data.fee + data.tax;                                               
                                           if(currBill> 0){
                                                $("#totalBill").text(currBill+subTotal);
                                                 $("#currBill").val($("#totalBill").text());
                                                 console.log($("#totalBill").text());
                                           }else{
                                                $("#totalBill").text(subTotal);
                                                 $("#currBill").val($("#totalBill").text());
                                                 console.log($("#totalBill").text());
                                           }
                                          
                        });
                
                });


        </script>   


    </body>                     
</html>
