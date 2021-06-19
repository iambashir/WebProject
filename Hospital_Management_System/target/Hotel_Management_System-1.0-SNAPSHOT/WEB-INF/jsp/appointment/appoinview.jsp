<%-- 
    Document   : View
    Created on : Aug 9, 2020, 10:38:02 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Appointment</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="/assets/test/styles.css" />

        <!--         W3School icon-->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!--         for delete-->
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
         <!--                medical icon-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         
        
        <!--                for datatable-->
<!--        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.js"></script>
        -->

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



        <div class="row">
            <div class="col-md-12"> 
<!--                <div class="col-md-1"></div> -->
                <div class="col-md-12">






                    <span></span><br>

                    <div style="text-align: center"><h2 style="color: #008CBA">Search Request of Appointments</h2><br></div>

                    <div class="row">
                        <div class="col-md-2"></div> 
                            <div class="col-md-8">
                           

                            <form action="/appoin/searchByLNameForAdmin" method="post">

                                <div class="col-md-4" style="color: #0056b3">
                                    <div class="form-group">
                                        <label for="lastname">Patient Last Name : </label>
                                        <input type="text" class="form-control" id="lastname" placeholder="Enter Patient last Name" name="lastname">
                                    </div>
                                </div> 
                                <div class="col-md-4" style="color: #0056b3">
                                    <div class="form-group">
                                        <label for="doctorname">Doctor Name : </label>
                                        <input type="doctorname" class="form-control" id="doctorname" placeholder="Enter Doctor Name" name="doctorname">
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




                    <div style="text-align: center">
                        <h1 style="color: #008CBA">All Request of Appointments list</h1>
                                
                                      <span></span><br>
                        
                        <table class="table table-hover" id="myTable">
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
                                    
                                    <th style="color: #0056b3">Code</th>

                                    <th style="color: #0056b3">Time</th>

                                    <th style="color: #0056b3">Action</th>
                                </tr>
                            </thead>
                            
                             
                            
                            <tbody>
                                <c:forEach items="${appoinList}" var="doc" varStatus="count">
                                    
                                    <form action="/appoin/AppoinmentApproveSave/{${count.index}}" method="post">
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
                                        <td style="color: #777777">${doc.code}</td>


                                         

                                        <td style="color: #777777">

                                            <input type="time" class="form-control" id="time" placeholder="Enter Time" name="time">
                                        </td>




                                        <td>

<!--                                            <form action="/appoin/AppoinmentApproveSave" method="post">-->



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
                                                <input type="hidden" name="code" value="${doc.code}"/>
                                                <input type="hidden" name="countNo" value="${count.index}"/>

<!--                                                <input type="submit" class="btn btn-success" value="Approve">-->
                                                <button type="submit" onclick="myFunction()" class="btn btn-success">Approve</button>
                                                
                                                <!--<button><i class='fas fa-check-circle' style='font-size:30px;color:green'></i></button>-->
<!--                                                <a type="submit" style="color: #4CAF50" onclick="approve()">
                                                    <i class='fas fa-check-circle' style='font-size:30px;color:green'></i>

                                                </a>-->
<!--                                            </form>-->


                                            <a href="#/appoin/edit/${doc.id}" style="color: blue">
                                                <i class="glyphicon glyphicon-remove" style="font-size:30px;color:red;"></i></a>

                                            <a href="/appoin/delete/${doc.id}" style="color: red">
                                                <i class='fas fa-trash-alt' style='font-size:30px;color:teal'></i>
                                            </a>



                                        </td>

                                    </tr>
                                    
                                     </form>
                                </c:forEach>


                            </tbody>
                        </table>
                             
                        
                       
                    </div>


                </div>
                <!--                <div class="col-md-1"></div> -->
            </div>
        </div>

       
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script>
        
        $("#inputTime").val($("#time").val());
        
    </script>-->



<!--         <script>
            $(document).ready(function () {
                $('#myTable').DataTable();
            });

        </script>-->

            <script>
function myFunction() {
  alert("Send an Email & SMS for this Current Appointments !");
}
</script>

    </body>
</html>
