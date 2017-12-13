<%-- 
    Document   : teachers_list
    Created on : 26-Jul-2015, 4:10:47 PM
    Author     : Marc-Antoine
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
        <title> list User Two</title>
         <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </head>
    <body>
        <h1>list User Two</h1>
        <c:if test="${!empty listUser}">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Course Two Name</th>
                    
                </tr>
                <c:forEach items="${listUser}" var="user">
                    <tr>
                        <td>${listUser.id}</td>
                        <td>${listUser.username}</td>
                        <td>${listUser.password}</td>
                        <td>${listUser.email}</td>
                        <td>${listUser.birthDate}</td>
                        <td>${listUser.profession}</td>
                        
                        <td><a href="<c:url value='/register/remove/${courseTwo.coursetwoid}' />" >Delete</a></td>
                        <td><a href="<c:url value='/register/user_manipulate/${courseTwo.coursetwoid}' />" >Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
            <br>
        </c:if>
        
        <a href="<c:url value='/register/user_manipulate' />" >Add User Form</a>
    </body>
</html>
