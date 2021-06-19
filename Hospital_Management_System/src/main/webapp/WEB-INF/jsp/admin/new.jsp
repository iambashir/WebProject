<%-- 
    Document   : new
    Created on : Aug 13, 2020, 8:59:41 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            
            <title>Home Page</title>
            <link rel="stylesheet" href="/assets/test/styles.css" />
            
             <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
            
            
            <style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 8px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}

.button2 {
  background-color: white; 
  color: black; 
  border: 2px solid #008CBA;
}

.button2:hover {
  background-color: #008CBA;
  color: white;
}

</style>
        </head>
        <body>
            
<!--            <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt=""></a>
       Uncomment below if you prefer to use an image logo 
       <h1 class="logo mr-auto"><a href="index.html">Medicio</a></h1> 

      <nav style="align-items: center" class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="index.html">Home</a></li>
          <li><a href="user/login">About</a></li>
          <li><a href="#services">Services</a></li>
          <li><a href="#departments">Departments</a></li>
          <li><a href="#doctors">Doctors</a></li>
           <li class="drop-down"><a href="">Drop Down</a>
          <ul>
            <li><a href="#">Drop Down 1</a></li>
            <li class="drop-down"><a href="#">Deep Drop Down</a>
              <ul>
                <li><a href="#">Deep Drop Down 1</a></li>
                <li><a href="#">Deep Drop Down 2</a></li>
                <li><a href="#">Deep Drop Down 3</a></li>
                <li><a href="#">Deep Drop Down 4</a></li>
                <li><a href="#">Deep Drop Down 5</a></li>
              </ul>
            </li>
            <li><a href="#">Drop Down 2</a></li>
            <li><a href="#">Drop Down 3</a></li>
            <li><a href="#">Drop Down 4</a></li>
          </ul>
        </li> 
          <li><a href="#contact">Contact</a></li>

        </ul>
      </nav> .nav-menu 

      <a href="#appointment" class="appointment-btn scrollto"><span class="d-none d-md-inline">Make an</span> Appointment</a>

    </div>
  </header>-->
<!--            
             End Header -->
            
       <%@include file="/assets/test/header.html"%>      
            
            
            <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Hospital Management System</a>
    </div>
      
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="/admin">Home</a></li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">User<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="user/create">Add User</a></li>
          <li><a href="#">User List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Doctor<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="doctor/create">Add Doctor</a></li>
          <li><a href="doctor/view">Doctor List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Add Patient</a></li>
          <li><a href="#">Patient List</a></li>
        </ul>
      </li>
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Receptionist<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Add Receptionist</a></li>
          <li><a href="#">Receptionist List</a></li>
        </ul>
      </li>
      
      <li><a href="user/login">Logout</a></li>
      
    </ul>
         
  </div>
</nav>
            
            
            
            
            
            
            
            
            
        
         
         
         <table width="100%" height="400px">
             <tr align="center">
                 <td class="menu">
                   <%@include file="/assets/test/menu1.jsp"%>
                 </td>
                 <td valign="top">
                     
                     
                     <br>     <br>      <br>
                     
                                <div class="row">
            
            <div class="col-md-12"> 
                <div class="col-md-4">HELLO
                
                <img src="/assets/test/doctor.png" alt="Trulli" width="400" height="333">
                </div>
                 <div class="col-md-4">HOW
                 <img src="/assets/test/doctor2.png" alt="Trulli" width="400" height="333">
                 </div>
                  <div class="col-md-4"> ARE YOU???
                  <img src="/assets/test/doctor3.png" alt="Trulli" width="400" height="333">
                  </div>
            </div>
            </div>
                     

        

                 </td>
             </tr>
         </table>
        </body>
    </html>