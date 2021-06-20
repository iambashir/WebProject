<%-- 
    Document   : ReceptionistProfile
    Created on : Aug 28, 2020, 8:06:08 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receptionist Profile</title>
        
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
         <link rel="stylesheet" href="/assets/test/styles.css" />
         
          <!--                medical icon-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         
        
         
         
         
         <style>
             body{
    background: #eaeaea;
    margin-top:20px;
}
.profile-info-list {
    padding: 0;
    margin: 0;
    list-style-type: none;
}
.friend-list,
.img-grid-list {
    margin: -1px;
    list-style-type: none;
}
.profile-info-list > li.title {
    font-size: 0.625rem;
    font-weight: 700;
    color: #8a8a8f;
    padding: 0 0 0.3125rem;
}
.profile-info-list > li + li.title {
    padding-top: 1.5625rem;
}
.profile-info-list > li {
    padding: 0.625rem 0;
}
.profile-info-list > li .field {
    font-weight: 700;
}
.profile-info-list > li .value {
    color: #666;
}
.profile-info-list > li.img-list a {
    display: inline-block;
}
.profile-info-list > li.img-list a img {
    max-width: 2.25rem;
    -webkit-border-radius: 2.5rem;
    -moz-border-radius: 2.5rem;
    border-radius: 2.5rem;
}
.coming-soon-cover img,
.email-detail-attachment .email-attachment .document-file img,
.email-sender-img img,
.friend-list .friend-img img,
.profile-header-img img {
    max-width: 100%;
}
.table.table-profile th {
    border: none;
    color: #000;
    padding-bottom: 0.3125rem;
    padding-top: 0;
}
.table.table-profile td {
    border-color: #c8c7cc;
}
.table.table-profile tbody + thead > tr > th {
    padding-top: 1.5625rem;
}
.table.table-profile .field {
    color: #666;
    font-weight: 600;
    width: 25%;
    text-align: right;
}
.table.table-profile .value {
    font-weight: 500;
}
.profile-header {
    position: relative;
    overflow: hidden;
}
.profile-header .profile-header-cover {
    background: url(https://bootdey.com/img/Content/bg1.jpg) center no-repeat;
    background-size: 100% auto;
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
}
.profile-header .profile-header-cover:before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: linear-gradient(to bottom, rgba(0, 0, 0, 0.25) 0, rgba(0, 0, 0, 0.85) 100%);
}
.profile-header .profile-header-content,
.profile-header .profile-header-tab,
.profile-header-img,
body .fc-icon {
    position: relative;
}
.profile-header .profile-header-tab {
    background: #fff;
    list-style-type: none;
    margin: -1.25rem 0 0;
    padding: 0 0 0 8.75rem;
    border-bottom: 1px solid #c8c7cc;
    white-space: nowrap;
}
.profile-header .profile-header-tab > li {
    display: inline-block;
    margin: 0;
}
.profile-header .profile-header-tab > li > a {
    display: block;
    color: #000;
    line-height: 1.25rem;
    padding: 0.625rem 1.25rem;
    text-decoration: none;
    font-weight: 700;
    font-size: 0.75rem;
    border: none;
}
.profile-header .profile-header-tab > li.active > a,
.profile-header .profile-header-tab > li > a.active {
    color: #007aff;
}
.profile-header .profile-header-content:after,
.profile-header .profile-header-content:before {
    content: "";
    display: table;
    clear: both;
}
.profile-header .profile-header-content {
    color: #fff;
    padding: 1.25rem;
}
body .fc th a,
body .fc-ltr .fc-basic-view .fc-day-top .fc-day-number,
body .fc-widget-header a {
    color: #000;
}
.profile-header-img {
    float: left;
    width: 7.5rem;
    height: 7.5rem;
    overflow: hidden;
    z-index: 10;
    margin: 0 1.25rem -1.25rem 0;
    padding: 0.1875rem;
    -webkit-border-radius: 0.25rem;
    -moz-border-radius: 0.25rem;
    border-radius: 0.25rem;
    background: #fff;
}
.profile-header-info h4 {
    font-weight: 500;
    margin-bottom: 0.3125rem;
}
.profile-container {
    padding: 1.5625rem;
}
@media (max-width: 967px) {
    .profile-header-img {
        width: 5.625rem;
        height: 5.625rem;
        margin: 0;
    }
    .profile-header-info {
        margin-left: 6.5625rem;
        padding-bottom: 0.9375rem;
    }
    .profile-header .profile-header-tab {
        padding-left: 0;
    }
}
@media (max-width: 767px) {
    .profile-header .profile-header-cover {
        background-position: top;
    }
    .profile-header-img {
        width: 3.75rem;
        height: 3.75rem;
        margin: 0;
    }
    .profile-header-info {
        margin-left: 4.6875rem;
        padding-bottom: 0.9375rem;
    }
    .profile-header-info h4 {
        margin: 0 0 0.3125rem;
    }
    .profile-header .profile-header-tab {
        white-space: nowrap;
        overflow: scroll;
        padding: 0;
    }
    .profile-container {
        padding: 0.9375rem 0.9375rem 3.6875rem;
    }
    .friend-list > li {
        float: none;
        width: auto;
    }
}
.profile-info-list {
    padding: 0;
    margin: 0;
    list-style-type: none;
}
.friend-list,
.img-grid-list {
    margin: -1px;
    list-style-type: none;
}
.profile-info-list > li.title {
    font-size: 0.625rem;
    font-weight: 700;
    color: #8a8a8f;
    padding: 0 0 0.3125rem;
}
.profile-info-list > li + li.title {
    padding-top: 1.5625rem;
}
.profile-info-list > li {
    padding: 0.625rem 0;
}
.profile-info-list > li .field {
    font-weight: 700;
}
.profile-info-list > li .value {
    color: #666;
}
.profile-info-list > li.img-list a {
    display: inline-block;
}
.profile-info-list > li.img-list a img {
    max-width: 2.25rem;
    -webkit-border-radius: 2.5rem;
    -moz-border-radius: 2.5rem;
    border-radius: 2.5rem;
}
.coming-soon-cover img,
.email-detail-attachment .email-attachment .document-file img,
.email-sender-img img,
.friend-list .friend-img img,
.profile-header-img img {
    max-width: 100%;
}
.table.table-profile th {
    border: none;
    color: #000;
    padding-bottom: 0.3125rem;
    padding-top: 0;
}
.table.table-profile td {
    border-color: #c8c7cc;
}
.table.table-profile tbody + thead > tr > th {
    padding-top: 1.5625rem;
}
.table.table-profile .field {
    color: #666;
    font-weight: 600;
    width: 25%;
    text-align: right;
}
.table.table-profile .value {
    font-weight: 500;
}

.friend-list {
    padding: 0;
}
.friend-list > li {
    float: left;
    width: 50%;
}
.friend-list > li > a {
    display: block;
    text-decoration: none;
    color: #000;
    padding: 0.625rem;
    margin: 1px;
    background: #fff;
}
.friend-list > li > a:after,
.friend-list > li > a:before {
    content: "";
    display: table;
    clear: both;
}
.friend-list .friend-img {
    float: left;
    width: 3rem;
    height: 3rem;
    overflow: hidden;
    background: #efeff4;
}
.friend-list .friend-info {
    margin-left: 3.625rem;
}
.friend-list .friend-info h4 {
    margin: 0.3125rem 0;
    font-size: 0.875rem;
    font-weight: 600;
}
.friend-list .friend-info p {
    color: #666;
    margin: 0;
}
             
         </style>
    </head>
    <body>
         <%@include file="/assets/test/header.html"%>
         
      <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
<!--      <a class="navbar-brand" href="#">Hospital Management System</a>-->
      <a class="navbar-brand" href="#">Welcome to Receptionist panel</a>
      <a href="/index"><i class="fa fa-stethoscope" style="font-size:48px;color:#008CBA"></i></a> 
    </div>
      
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="/Receptionist">Home</a></li>
      <li><a href="/rec/recepProfile/${user.code}">Profile</a></li>
      <li><a href="/doctor/recepDocList">Doctor</a></li>
      <li><a href="/rec/recpListForRecPanel">Receptionist</a></li>
      
      
      
     
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Add Patient</a></li>
          <li><a href="/appoin/PatientListforReceptionist">Patient List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Appointment<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/appoin/CreateAppointmentForReceptionist">Make Appointment</a></li>
          <li><a href="/appoin/viewForReceptionist">Appointment List</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Invoice<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/invoice/createFromReceptionist">Create Invoice</a></li>
          <li><a href="/invoice/InvoiceListforReceptionist">Doctor done Patient List</a></li>
        </ul>
      </li>
      
      
       
      
      <li><a href="/user/login">Logout</a></li>
      
    </ul>
         
  </div>
</nav>
<!--            End nav-->

        
<!--                        Profile start-->


<div class="container">
<div id="content" class="content p-0">
    <div class="profile-header">
        <div class="profile-header-cover"></div>

        <div class="profile-header-content">
            <div class="profile-header-img">
                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="" />
            </div>

            <div class="profile-header-info">
                <h4 class="m-t-sm">Receptionist</h4>
                <p class="m-b-sm">${rec.firstname} ${rec.lastname}</p>
                <a href="#" class="btn btn-xs btn-primary mb-3">Edit Profile</a>
            </div>
        </div>
<!--
        <ul class="profile-header-tab nav nav-tabs">
            <li class="nav-item"><a href="#profile-post" class="nav-link" data-toggle="tab">POSTS</a></li>
            <li class="nav-item"><a href="#profile-about" class="nav-link active show" data-toggle="tab">ABOUT</a></li>
            <li class="nav-item"><a href="#profile-photos" class="nav-link" data-toggle="tab">PHOTOS</a></li>
            <li class="nav-item"><a href="#profile-videos" class="nav-link" data-toggle="tab">VIDEOS</a></li>
            <li class="nav-item"><a href="#profile-friends" class="nav-link" data-toggle="tab">FRIENDS</a></li>
        </ul>-->
    </div>

    <div class="profile-container">
        <div class="row row-space-20">
            <div class="col-md-8">
                <div class="tab-content p-0">
                    <div class="tab-pane active show" id="profile-about">
                        <table class="table table-profile">
                            <thead>
                                <tr>
                                    <th colspan="2">WORK AND EDUCATION</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="field">Work</td>
                                    <td class="value">
                                        <div class="m-b-5">
                                            <b>Receptionist</b> <a href="#" class="m-l-10">Edit</a><br />
                                            <span class="text-muted">MEDICIO HOSPITAL</span>
                                        </div>
                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Education</td>
                                    <td class="value">
                                        <div class="m-b-5">
                                            <b>University (2009)</b> <a href="#" class="m-l-10">Edit</a><br />
                                            <span class="text-muted">University of Georgia, Athens, GA</span>
                                        </div>
                                        <div>
                                            <b>High School (2006)</b> <a href="#" class="m-l-10">Edit</a><br />
                                            <span class="text-muted">Heritage High School, West Chestter, PA</span>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Skills</td>
                                    <td class="value">
                                        Manage Reception
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table class="table table-profile">
                            <thead>
                                <tr>
                                    <th colspan="2">CONTACT INFORMATION</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="field">Mobile Phones</td>
                                    <td class="value">
                                        ${rec.mobile}
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Email</td>
                                    <td class="value">
                                        ${rec.email}
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Facebook</td>
                                    <td class="value">
                                        http://facebook.com/infinite.admin
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Website</td>
                                    <td class="value">
                                        http://seantheme.com
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Address</td>
                                    <td class="value">
                                        ${rec.address}<a href="#" class="m-l-10">Edit</a><br />
                                        1355 Market Street, Suite 900<br />
                                        San Francisco, CA 94103
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table class="table table-profile">
                            <thead>
                                <tr>
                                    <th colspan="2">BASIC INFORMATION</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="field">Birth of Date</td>
                                    <td class="value">
                                        November 4, 1989
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Gender</td>
                                    <td class="value">
                                       ${rec.gender}
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Facebook</td>
                                    <td class="value">
                                        http://facebook.com/infinite.admin
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="field">Website</td>
                                    <td class="value">
                                        http://seantheme.com
                                        <a href="#" class="m-l-10">Edit</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="col-md-4 hidden-xs hidden-sm">
                <ul class="profile-info-list">
                    <li class="title">PERSONAL INFORMATION</li>
                    <li>
                        <div class="field">Occupation:</div>
                        <div class="value">${rec.specialization}</div>
                    </li>           
                    <li>
                        <div class="field">Qualification:</div>
                        <div class="value">BSS, ${rec.qualification}</div>
                    </li>
                    <li>
                        <div class="field">Birth of Date:</div>
                        <div class="value"> ${rec.date}</div>
                    </li>
                    <li>
                        <div class="field">Country:</div>
                        <div class="value">Bangladesh</div>
                    </li>
                    <li>
                        <div class="field">Address:</div>
                        <div class="value">
                            <address class="m-b-0">
                                 ${rec.address}<br />
                                1355 Market Street, Suite 900<br />
                                San Francisco, CA 94103
                            </address>
                        </div>
                    </li>
                    <li>
                        <div class="field">Phone No.:</div>
                        <div class="value">
                             ${rec.mobile}
                        </div>
                    </li>
                    
                </ul>
            </div>
        </div>
    </div>
</div>
</div>



         
    </body>
</html>
