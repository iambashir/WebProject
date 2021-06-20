
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Doctor</title>
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
                    
                    <div style="color: #008CBA">
                    <h1 style="text-align: center">Add Doctor</h1><br>
                    </div>
                    
                    
                     <div style="color: #4CAF50">
                         <h4 style="text-align: center">${map.success}</h4>
                     </div>
                   
                    <br>
                    
                    <form action="/doctor/save" method="post">
                        
                        <div class="form-row">
                            
                            
                            
                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="code">Code : </label>
                            <input type="text" class="form-control" id="code" placeholder="Enter Code" name="code" data-msg="Please enter at least 4 chars">
                        </div>
                            
                                    
                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="firstname">First Name : </label>
                            <input type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstname" data-msg="Please enter at least 4 chars">
                        </div>
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="lastname">Last Name : </label>
                            <input type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastname">
                        </div>
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="username">Username : </label>
                            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
                        </div>
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="email">Email : </label>
                            <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
                        </div>
                        
                         <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="password">Password : </label>
                            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
                        </div>
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="address">Address : </label>
                            <input type="address" class="form-control" id="address" placeholder="Enter Address" name="address">
                        </div>
                        
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="mobile">Mobile Number : </label>
                            <input type="mobile" class="form-control" id="mobile" placeholder="Enter Mobile Number" name="mobile" required="">
                        </div>
                        
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="gender">Select Gender : </label>
                            <select class="form-control" id="gender" name="gender">
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                            </select>
                        </div>
                        
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="date">Date of Birth : </label>
                            <input type="date" class="form-control" id="date" placeholder="Enter date" name="date">
                        </div>
                        
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="city">City : </label>
                            <input type="city" class="form-control" id="city" placeholder="Enter city" name="city">
                        </div>
                        
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="cnp">C.N.P : </label>
                            <input type="cnp" class="form-control" id="cnp" placeholder="Enter C.N.P" name="cnp">
                        </div>
                        
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="qualification">Qualification : </label>
                            <input type="qualification" class="form-control" id="qualification" placeholder="Enter Qualification" name="qualification">
                        </div>
                        
                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                            <label for="specialization">Specialization : </label>
                            <input type="specialization" class="form-control" id="specialization" placeholder="Enter specialization" name="specialization">
                        </div>
                        
                            <br> <br> <br> <br> <br> <br> <br> <br>
                            
                            <div class="form-group col-md-4 mb-3">
                                <br> <br> <br> <br>
<!--                        <button type="submit" class="btn btn-default">Add Doctor</button>-->
<!--                         <button type="reset" class="btn btn-black disabled">Back</button>-->
                         <button type="reset" class="btn btn-primary">Reset</button>
                         <input type="submit" class="btn btn-success" value="Save Doctor">
                        
<!--                        <a href="/user/login">Login user</a>-->
                        </div>
                        
                        
                        </div>
                        
                    </form>
                </div>
                <div class="col-md-2"></div>

            </div>
        </div>


  
</body>
</html>