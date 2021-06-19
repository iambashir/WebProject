<%-- 
    Document   : TempletAppoinment
    Created on : Aug 24, 2020, 9:39:56 AM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request for an Appointment From Templet</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
         <link rel="stylesheet" href="/assets/test/styles.css" />
<!--         For icon-->
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
         
    </head>
    <body>
        



 <%@include file="/assets/test/header.html"%>
         
        








                    
        <span></span>
        <div class="row">
            <div class="col-md-12"> 
                <div class="col-md-2">
                    <br>
                    <a href="/index"><i class='fas fa-arrow-circle-left' style='font-size:48px;color:#4CAF50'></i></a>
                </div> 
                <div class="col-md-8">
                    
                    <div style="color: #008CBA">
                    <h1 style="text-align: center">Request for an Appointment</h1><br>
                    </div>
                    
                    <div style="color: #4CAF50">
                         <h4 style="text-align: center">${map.success}</h4>
                     </div>
                    
                     <br>
                    
                   <form action="/appoin/AppoinSave" method="post">

                        <div class="form-row">


                            <!--                      <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                                        <label for="branch">branch : </label>
                                                        <input type="text" class="form-control" id="branch" placeholder="Enter branch" name="branch">
                                                    </div> -->

                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="branch">Select Branch : </label>
                                <select class="form-control" id="branch" name="branch">
                                    <option value="Dhaka">Dhaka</option>
                                    <option value="Dhaka">Sylhet</option>
                                    <option value="Khulna">Khulna</option>
                                    <option value="Barishal">Barishal</option>
                                </select>

                            </div>

                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="date">Date : </label>
                                <input type="date" class="form-control" id="date" placeholder="Enter date" name="date">
                            </div>

                            <!--                          <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                                        <label for="department">Department : </label>
                                                        <input type="text" class="form-control" id="qualification" placeholder="Enter Department" name="department">
                                                    </div>   -->


                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="department">Select Department : </label>
                                <select class="form-control" id="department" name="department">
                                    <!--                 <option value="">Select Speciality</option>-->
                                    <option value="Orthopedics">Medicine</option>
                                    <option value="Cardiology">Cardiology</option>
                                    <option value="Surgery">Surgery</option>
                                    
<!--                                    <option value="Paediatric">Paediatric</option>
                                   
                                    <option value="Neonatology">Neonatology</option>
                                    <option value="Neurology">Neurology</option>
                                    <option value="Orthopedics">Orthopedics</option>-->
                                   
                                </select>

                            </div>






                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="doctorname">Select Doctor : </label>
                                <select class="form-control" id="doctorname" name="doctorname">
                                    <c:forEach items="${docs}" var="doc">
                                        <option value="${doc.code}">${doc.firstname} ${doc.lastname}</option>
                                    </c:forEach> 
                                </select>
                                <input type="hidden" name="codeDoc" id="codeDoc"/>
                                <input type="hidden" name="nameDoc" id="nameDoc"/>
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
                                <label for="email">Email : </label>
                                <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
                            </div>


                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="address">Address : </label>
                                <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
                            </div>

                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="mobile">Mobile Number : </label>
                                <input type="tel" class="form-control" id="mobile" placeholder="Enter Mobile Number" name="mobile" required="">
                            </div>

                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="gender">Select Gender : </label>
                                <select class="form-control" id="gender" name="gender">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </div>





                            <!--                        <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                                        <label for="time">Time</label>
                                                        <input type="time" class="form-control" id="time" placeholder="Enter Time" name="time">
                                                    </div>-->

                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="address">Age : </label>
                                <input type="text" class="form-control"  placeholder="Enter Address">
                            </div>

                            <div class="form-group col-md-4 mb-3" style="color: #008CBA">
                                <label for="address">Remark : </label>
                                <textarea class="form-control"  rows="2" placeholder="Message (Optional)"></textarea>
                            </div>







                            <!--                            <br> <br> <br> <br> <br> <br> <br> <br>-->

                            <div class="form-group col-md-4 mb-3">
                                <br> <br> 
                                <!--                        <button type="submit" class="btn btn-default">Add Doctor</button>-->
                                <!--                         <button type="reset" class="btn btn-black disabled">Back</button>-->
                                <button type="reset" class="btn btn-primary">Reset</button>
                                <input type="submit" class="btn btn-success" value="Send Request">

                                <!--                        <a href="/user/login">Login user</a>-->
                            </div>


                        </div>

                    </form>
                </div>
                <div class="col-md-2"></div>

            </div>
        </div>

        <script>
        </script>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


        <script>
            $("#codeDoc").val($("#doctorname option:selected").val());
            
            $("#doctorname").on("change", function(){
                $("#codeDoc").val($("#doctorname option:selected").val());
            });
            
            $("#nameDoc").val($("#doctorname option:selected").text());
            
            $("#doctorname").on("change", function(){
                $("#nameDoc").val($("#doctorname option:selected").text());
            });
        </script>
        



</body>
</html>
