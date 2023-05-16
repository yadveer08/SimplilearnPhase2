<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Class Management System</h1>
    <hr>
    <h2>Add Class</h2>
    <form action="ClassServlet" method="POST">
    <label>Name:</label> <input type="text" name="name"><br>
    <label>Teacher:</label> 
    <select name="teacherId">
        <c:forEach items="${teachers}" var="teacher">
            <option value="${teacher.id}">${teacher.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="Add">
	</form>
	<hr>
	<h2>List of Classes</h2>
	<table border="1">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Name</th>
	            <th>Teacher</th>
	            <th>Edit</th>
	            <th>Delete</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${classes}" var="class">
	            <tr>
	                <td>${class.id}</td>
	                <td>${class.name}</td>
	                <td>${class.teacher.name}</td>
	                <td><a href="ClassServlet?action=edit&id=${class.id}">Edit</a></td>
	                <td><a href="ClassServlet?action=delete&id=${class.id}">Delete</a></td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>

</body>
</html>