<%-- 
    Document   : MyAppoinment
    Created on : Aug 25, 2020, 9:06:04 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Appoinment</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="/assets/test/styles.css" />
        
        <!--                medical icon-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        
        <!--         W3School icon-->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!--         for delete-->
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
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
                    <span></span><br>
                   




                    <div style="text-align: center">
                        <h1 style="color: #008CBA">List of my all Appointments</h1>
                                
                                <span></span><br>
                        
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th style="color: #0056b3">First Name</th>
                                    <th style="color: #0056b3">Last Name</th>
                                    <th style="color: #0056b3">Doctor Name</th>
                                    <th style="color: #0056b3">Email</th>

                                    <th style="color: #0056b3">Address</th>
                                    <th style="color: #0056b3">Mobile Number</th>
                                    <th style="color: #0056b3">Gender</th>
                                    <th style="color: #0056b3">Date</th>

                                    <th style="color: #0056b3">Department</th>


                                    <th style="color: #0056b3">Branch</th>

                                    <th style="color: #0056b3">Time</th>
                                    
                                    <th style="color: #0056b3">Doctor Code</th>

                                    <th style="color: #0056b3">Action</th>
                                </tr>
                            </thead>
                            
                             
                            
                            <tbody>
                                <c:forEach items="${appoinList}" var="doc">
                                    

                                    <tr>
                                        <td style="color: #777777">${doc.firstname}</td>
                                        <td style="color: #777777">${doc.lastname}</td>
                                        <td style="color: #777777">${doc.doctorname}</td>
                                        <td style="color: #777777">${doc.email}</td>

                                        <td style="color: #777777">${doc.address}</td>
                                        <td style="color: #777777">${doc.mobile}</td>
                                        <td style="color: #777777">${doc.gender}</td>
                                        <td style="color: #777777">${doc.date}</td>

                                        <td style="color: #777777">${doc.department}</td>
                                        <td style="color: #777777">${doc.branch}</td>
                                        <td style="color: #777777">${doc.time}</td>
                                        <td style="color: #777777">${doc.code}</td>


                                        <td>
                                            <form action="/invoice/saveInvoice/" method="post">
                                                <input type="hidden" name="firstname" value="${doc.firstname}"/>
                                                <input type="hidden" name="lastname" value="${doc.lastname}"/>
                                                <input type="hidden" name="doctorname" value="${doc.doctorname}"/>
                                                <input type="hidden" name="email" value="${doc.email}"/>
                                                <input type="hidden" name="address" value="${doc.address}"/>
                                                <input type="hidden" name="mobile" value="${doc.mobile}"/>
                                                <input type="hidden" name="gender" value="${doc.gender}"/>
                                                <input type="hidden" name="date" value="${doc.date}"/>
                                                <input type="hidden" name="department" value="${doc.department}"/>
                                                <input type="hidden" name="branch" value="${doc.branch}"/>
                                                <input type="hidden" name="time" value="${doc.time}"/>
                                                <input type="hidden" name="code" value="${doc.code}"/>
                                                
<!--                                                <input type="submit" onclick="myFunction()" class="btn btn-success" value="Done">-->
                                                <button type="submit" onclick="myFunction()" class="btn btn-success">Done</button>
                                            
                                            </form>
                                            
                                            <a href="#/appoin/edit/${doc.id}" style="color: blue">
                                                <i class="glyphicon glyphicon-remove" style="font-size:30px;color:red;"></i></a>

                                            <a href="/appoin/delete/${doc.id}" style="color: red">
                                                <i class='fas fa-trash-alt' style='font-size:30px;color:teal'></i>
                                            </a>



                                        </td>

                                    </tr>
                                    

                                </c:forEach>


                            </tbody>
                        </table>
                             
                        
                       
                    </div>
                      
                                                
                         </div>
               
            </div>
        </div>   


                                                
<script>
function myFunction() {
  alert("The service is done!");
}
</script>


        
    </body>
</html>
