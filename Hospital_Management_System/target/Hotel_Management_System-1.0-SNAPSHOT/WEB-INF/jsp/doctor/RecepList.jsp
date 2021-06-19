<%-- 
    Document   : RecepList
    Created on : Aug 21, 2020, 5:58:17 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receptionist List for doctor panel</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
         <link rel="stylesheet" href="/assets/test/styles.css" />
         
         <!--                medical icon-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         
<!--         ++++++++++++++ For table data++++++++++++++++++++++-->
         <link rel="stylesheet" href="/assets/test/styles.css" />
         <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.css"/>
         <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.js"></script>
        
    </head>
    <body>
        <%@include file="/assets/test/header.html"%>
        
        
        
        
      <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
<!--      <a class="navbar-brand" href="#">Hospital Management System</a>-->
      <a class="navbar-brand" href="#">Welcome to Doctors panel</a>
      <a href="/index"><i class="fa fa-user-md" style="font-size:48px;color:#007aff"></i></a> 
    </div>
      
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="/doctor">Home</a></li>
      <li><a href="/doctor/DoctorProfile/${user.code}">Profile</a></li>
      <li><a href="/appoin/MyAppoinment/${user.code}">My Appoinment</a></li>
      <li><a href="/doctor/doctorview">Doctors</a></li>
      <li><a href="/rec/recpList">Receptionists</a></li>
      


      
       
      
      <li><a href="/user/login">Logout</a></li>
      
    </ul>
         
  </div>
</nav>
<!--            End nav-->
        
        
        
        <div class="row">
            <div class="col-md-12"> 
                
                <div class="col-md-12">
    
        
        
        
        
                         
                          <span></span><br>
         
         <div style="text-align: center"><h1 style="color: #008CBA">Search Receptionist</h1><br></div>
         
        <div class="row">
            <div class="col-md-2"></div> 
            <div class="col-md-8"> 
                
                
                
                <form action="/doctor/viewByLName" method="post">
                
                <div class="col-md-4" style="color: #0056b3">
                    <div class="form-group">
                            <label for="lastname">Last Name : </label>
                            <input type="text" class="form-control" id="lastname" placeholder="Enter Lastname" name="lastname">
                        </div>
                </div> 
                 <div class="col-md-4" style="color: #0056b3">
                    <div class="form-group">
                            <label for="qualification">Qualification : </label>
                            <input type="qualification" class="form-control" id="qualification" placeholder="Enter Qualification" name="qualification">
                        </div>
                </div>
                
                <div class="col-md-4">
                    <span></span><br/>
                    <button type="submit" class="button button1">Search</button>
                    <button type="reset" class="button button2">Reset</button>
                </div>
                    
                    </form>
               
                

            </div>
            <div class="col-md-2"></div> 
         </div>
                     <span></span><br>
                      <span></span><br>
                      
        
        
        
        
                      <div style="text-align: center">
                    <h1 style="color: #008CBA">List of all Receptionists</h1>
                    
                    <span></span><br>
                    
                    <table class="table table-hover" id="myTable">
                        <thead>
                            <tr>
                                <th style="color: #0056b3">First Name</th>
                                <th style="color: #0056b3">Last Name</th>
                                <th style="color: #0056b3">Username</th>
                                 <th style="color: #0056b3">Email</th>
                                  <th style="color: #0056b3">Password</th>
                                   <th style="color: #0056b3">Address</th>
                                   <th style="color: #0056b3">Mobile Number</th>
                                   <th style="color: #0056b3">Gender</th>
                                   <th style="color: #0056b3">city</th>
                                   <th style="color: #0056b3">Qualification</th>
<!--                                   <th style="color: #0056b3">Action</th>-->
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${recList}" var="doc">
                            <tr>
                                <td style="color: #777777">${doc.firstname}</td>
                                <td style="color: #777777">${doc.lastname}</td>
                                <td style="color: #777777">${doc.username}</td>
                                <td style="color: #777777">${doc.email}</td>
                                <td style="color: #777777">${doc.password}</td>
                                <td style="color: #777777">${doc.address}</td>
                                <td style="color: #777777">${doc.mobile}</td>
                                <td style="color: #777777">${doc.gender}</td>
                                <td style="color: #777777">${doc.city}</td>
                                <td style="color: #777777">${doc.qualification}</td>
<!--                                <td>
                                    <a href="/rec/edit/${doc.id}" style="color: blue">Edit</a>
                                    <a href="/rec/delete/${doc.id}" style="color: red">Delete</a>
                                </td>-->
                                
                            </tr>
                        </c:forEach>
                            
                            
                        </tbody>
                    </table>
                </div>
                      
                      </div>
<!--                <div class="col-md-1"></div> -->
            </div>
            </div>
        
         <script>
            $(document).ready(function () {
                $('#myTable').DataTable();
            });

        </script>

        
        
    </body>
</html>
