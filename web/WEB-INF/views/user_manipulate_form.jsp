<%-- 
    Document   : teachersedit_form
    Created on : Jun 11, 2017, 5:09:42 PM
    Author     : hamid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manipulate Form</title>
         <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </head>
    <body>
        <body data-spy="scroll" data-target="#myScrollspy" data-offset="20">

<div class="container">
  <div class="row">
    <nav class="col-sm-3" id="myScrollspy">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="<c:url value='/teachers/teacher_manipulate' />">TEACHERS Page</a></li>
        
        <li><a href="<c:url value='/register/user_manipulate' />">USERS Page</a></li>
        <li><a href="<c:url value='/student/student_manipulate' />">STUDENTS Page</a></li>
        <li><a href="<c:url value='/courseTwo/courseTwo_manipulate' />">COURSES Page</a></li>
        <li><a href="<c:url value='/mark/mark_form' />">MARKS</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">About Us <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#section41">Contact Us</a></li>
            <li><a href="#section42">Address</a></li>
            <li><a href="#section43">General Information</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    <div class="col-sm-9">
      <div id="section1">    
        <h1>Section 1</h1>
        <p>Try to scroll this section and look at the navigation list while scrolling!</p>
      </div>
      <div id="section2"> 
           <form:form method = "Post" action="${action}" commandName="user">  
          
         <form:input type="hidden" path="id" />  
         <div class="form-group">
    <label for="user">User Name :</label>
    <form:input type="text" path="username" class="form-control" id="user" />
         </div>
         <div class="form-group">
    <label for="password">Password : </label>
     <form:input type="password" path="password" class="form-control" id="password" />
         </div>
              
            <div class="form-group">
    <label for="email">Email: </label>
  <form:input type="email" class="form-control" id="email" path="email"  />
         </div>
             
          <div class="form-group">
    <label for="birth">Birth date: </label>
    <form:input type="date" class="form-control" id="birth" path="birthDate"  />
         </div>         
            
             <div class="form-group">
    <label for="sel">Profession: </label>
    <div><form:select path="profession" items="${professionList}"  /></div>
         </div>  
            <button type="submit" class="btn btn-default" value="Save" />Submit</button>           
              
            
       </form:form> 
              </form> 
        <div><a href="<c:url value='/register/user_manipulate' />">Add User form</a></div>
      </div>        
      <div id="section3">         
        <h1>Section 3</h1>
        <p>Try to scroll this section and look at the navigation list while scrolling!</p>
      </div>
      <div id="section41">         
        <h1>Section 4-1</h1>
        <p>Try to scroll this section and look at the navigation list while scrolling!</p>
      </div>      
      <div id="section42">         
        <h1>Section 4-2</h1>
        <p>Try to scroll this section and look at the navigation list while scrolling!</p>
      </div>
    </div>
  </div>
</div>

</body>
        
    </body>
</html>
