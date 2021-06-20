<%-- 
    Document   : createService
    Created on : Aug 24, 2020, 9:45:01 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Service</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
         <link rel="stylesheet" href="/assets/test/styles.css" />
         
          <!--                medical icon-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         
        
        
        
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


   <span></span>
        <div class="row">
            <div class="col-md-12"> 
                <div class="col-md-2"></div> 
                <div class="col-md-8">
                    
                    <div style="color: #6c757d">
                        <h1 style="text-align: center">Add Services<br>--------------------</h1><br>
                   
                    </div>
                    <form action="/addService/save" method="post">
                        
                        <div class="form-row">
                            
                            
                            
                            <div class="row">
            <div class="col-md-12"> 
                <div class="col-md-4">
                    
                   
                        
                         <div class="form-group" style="color: #008CBA">
              <label for="category">Select Category : </label>
              <select class="form-control" id="category" name="category">
                
                <option value="Doctor Visit">Doctor Visit</option>
                <option value="Ambulance">Ambulance</option>
                <option value="Pathology">Pathology</option>
                <option value="Pharmacy">Pharmacy</option>
              </select>
            
              </div>
                            
                 
                    
                 <div class="form-group" style="color: #008CBA">
           <label for="servicecode">Service Code : </label>
           <input type="text" class="form-control" id="servicecode" placeholder="Enter Service Code" name="servicecode">
           </div>     
                    
                        
           <div class="form-group" style="color: #008CBA">
           <label for="servicename">Service Name : </label>
           <input type="text" class="form-control" id="servicename" placeholder="Enter Service Name" name="servicename">
           </div>
                    
                    
           <div class="form-group">
                                <br> <br> 
<!--        <button type="submit" class="btn btn-default">Add Doctor</button>-->
<!--        <button type="reset" class="btn btn-black disabled">Back</button>-->
            <button type="reset" class="btn btn-primary">Reset</button>
            <input type="submit" class="btn btn-success" value="Save Services">
                        

            </div>          
                    
                    
                    </div> 
                    
                    
                   
                 <div class="col-md-4">    
                       
            <div class="form-group" style="color: #008CBA">
              <label for="fee">Service Fee : </label>
              <input type="fee" class="form-control" id="fee" placeholder="Enter Service Fee" name="fee">
            </div>  
                    
                    
           <div class="form-group" style="color: #008CBA">
         <label for="tax">Service Tax : </label>
         <input type="tax" class="form-control" id="tax" placeholder="Enter Service Duration" name="tax">
        </div>         
                    
                           

        <div class="form-group" style="color: #008CBA">
         <label for="duration">Service Duration : </label>
         <input type="duration" class="form-control" id="duration" placeholder="Enter Service Duration" name="duration">
        </div>
                 
          
          
                    
                    
        
        
       
                    
                    
                    
                </div> 
                <div class="col-md-4">
                    
              <div class="form-group" style="color: #008CBA">
         <label for="doctorcode">Doctor Code : </label>
         <input type="text" class="form-control" id="doctorcode" placeholder="Enter Doctor Code" name="doctorcode">
        </div>      
                    
                    
                    
                    
                    
       <div class="form-group" style="color: #008CBA">
       <label for="remark">Remark : </label>
       <textarea class="form-control"  rows="5" placeholder="Message (Optional)"></textarea>
      </div>  
                </div>
                            
                            </div>
                                </div>
                         
                       
                        </div>
                        
                    </form>
                </div>
                <div class="col-md-2"></div>

            </div>
        </div>

        
        
    </body>
</html>
