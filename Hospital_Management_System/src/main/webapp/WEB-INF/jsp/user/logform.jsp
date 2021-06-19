<%-- 
    Document   : create
    Created on : Jul 21, 2020, 10:51:33 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
         <link rel="stylesheet" href="/assets/test/styles.css" />
         
         
         
         <style>
		.box{
	width: 400px;
	position: absolute;		
	top :50%;		
	left: 50%;		
		transform: translate(-50%,-50%);
		padding: 50PX;
		background: darkcyan;
		border-radius: 10px;
		} 
                  </style>
         
         
         
    </head>
    <body>
        
         <%@include file="/assets/test/header.html"%>
        
<!--        <span></span><br><br>-->
        
        
        
	<div class="box">
        
        
<!--        <div class="row">
            <div class="col-md-12">
                <div class="col-md-4"></div>
                
                    <div class="col-md-4">-->
                        <div style="text-align: center"><h2 style=" color: #fff"><b>User Login</b></h2></div>
                    
                        <br>    
                        
                        <form action="/user/loginaction" method="post">
                            
                        
<!--                            <div class="form-group">-->
                                <label for="username" style=" color: #fff">User Name :</label>
                                <input type="text" class="form-control" id="username" placeholder="Enter Username" name="username" required="Please enter your username!">
<!--                            </div>-->
<!--                            <div class="form-group">-->
                                <label for="password" style=" color: #fff">Password :</label>
                                <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password" required="Please enter your Password!">
<!--                            </div>-->
                           
                           
<!--                             <a href="#">Forgot Password</a>-->

                                <br>

                            <div class="row">
                        <div class="col-md-12">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            
                             <button type="submit" class="btn btn-success">Login</button>
                        </div>
                        <div class="col-md-4"></div>
                       
                             
                             </div>
                                 </div>




                           
                            
                           
<!--                            <button type="button" class="btn btn-default" >Register</button>-->
                        </form>
<!--                    
                </div>
 <span></span><br> 
                <div class="col-md-8">

                </div>
            </div>

        </div>-->
        
        
        
        </div>
	
	
        
        
        
    </body>
</html>
