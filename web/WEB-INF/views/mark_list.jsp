<%-- 
    Document   : course_list
    Created on : 26-Jul-2015, 4:10:47 PM
    Author     : reza kesht kar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html ng-app="">
    < head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Marks</title>
         <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="../../JS/angular.min (1).js" type="text/javascript"></script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
<script src="../../../../../../Downloads/angular.min (1).js" type="text/javascript"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </head>
    <body>
        <h1>List Marks</h1>
        <c:if test="${!empty listMarks}">

            <select>
                <c:forEach items="${listMarks}" var="mark">
                    <option><c:url value="${mark.student.firstname}" /></option>
                </c:forEach>
            </select>

            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Student name</th>
                    <th>Teacher name</th>
                    <th>Course name</th>
                    <th>Mark</th>
                    <th><!--Action--></th>
                </tr>
                <c:forEach items="${listMarks}" var="markk">
                    <tr>
                        <td>${markk.mark_id}</td>
                        <td>${markk.student.firstname } + ${markk.student.lastname}</td>
                        <td>${markk.teacher.fname } + ${markk.teacher.lname}</td>
                        <td>${markk.course.coursename }</td>
                        <td>${markk.mark }</td>
                        
                        <!-- TODO: Create column for teacher, course and mark -->
                        <td><a href="<c:url value='/course/remove/${course.id}' />" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <br>
        </c:if>
        <a href="<c:url value='/course/course_form' />" >Add Course Form</a>
        <table>
   <tr>
      <th>Name</th>
      <th>Marks</th>
   </tr>
   
   <tr ng-repeat = "subject in ${listMarks}">
      <td>{{ subject.marks }}</td>
      <td>{{ welcom! }}</td>
   </tr>
</table>
    </body>
</html>
