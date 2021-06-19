<%-- 
    Document   : menu1
    Created on : Aug 13, 2020, 5:13:57 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
        
    </head>
    <body>
        
        
         
       <nav class="w3-sidebar w3-red w3-collapse  w3-large w3-padding" style="z-index:3;width:250px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
<!--  <div class="w3-container">
    <h3 class="w3-padding-64"><b>Company<br>Name</b></h3>
  </div>-->
  <div class="w3-bar-block">
    <a href="/admin" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
    <a href="/user/adminProfile" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Profile</a>  
    <a href="#services" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Audits Log</a>
    
    
    <div>
      <ol class="dropdown"><a class="dropdown w3-bar-item w3-button w3-hover-white"lass="dropdown-toggle" data-toggle="dropdown" href="#">User<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/user/create">Add User</a></li>
          <li><a href="/user/view">User List</a></li>
        </ul>
      </ol>
      </div>
    
    <div>
      <ol class="dropdown"><a class="dropdown w3-bar-item w3-button w3-hover-white"lass="dropdown-toggle" data-toggle="dropdown" href="#">Doctor<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/doctor/create">Add Doctor</a></li>
          <li><a href="/doctor/view">Doctor List</a></li>
        </ul>
      </ol>
      </div>
    
    <div>
      <ol class="dropdown"><a class="dropdown w3-bar-item w3-button w3-hover-white"lass="dropdown-toggle" data-toggle="dropdown" href="#">Patient<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#/doctor/create">Add Patient</a></li>
          <li><a href="#/doctor/view">Patient List</a></li>
        </ul>
      </ol>
      </div>
    
    <div>
      <ol class="dropdown"><a class="dropdown w3-bar-item w3-button w3-hover-white"lass="dropdown-toggle" data-toggle="dropdown" href="#">Receptionist<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/rec/create">Add Receptionist</a></li>
          <li><a href="/rec/view">Receptionist List</a></li>
        </ul>
      </ol>
      </div>
    
    
    
    <div>
      <ol class="dropdown"><a class="dropdown w3-bar-item w3-button w3-hover-white"lass="dropdown-toggle" data-toggle="dropdown" href="#">Appointment<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/appoin/create">Make Appointment</a></li>
          <li><a href="/appoin/view">Appointment List</a></li>
        </ul>
      </ol>
      </div>
    
    
    
    
    <a href="/user/login" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Logout</a> 
    
<!--    <a href="#packages" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Packages</a> 
    <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-blue">Contact</a>-->
    
  </div>
</nav>

    </body>
</html>
