<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Thank you for registering! Here's the review of your details:</h3>
                </td>
            </tr>
            <tr>
                <td>User Name:</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td>${user.birthDate}</td>
            </tr>
            <tr>
                <td>Profession:</td>
                <td>${user.profession}</td>
            </tr>
 
        </table>
    </div>
</body>
</html>