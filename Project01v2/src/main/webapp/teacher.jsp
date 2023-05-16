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

<h1>Teacher Management System</h1>
    <hr>
    <h2>Add Teacher</h2>
    <form action="TeacherServlet" method="POST">
        <label>Name:</label> <input type="text" name="name"><br/>
        <label>Age:</label> <input type="number" name="age"><br>
    <input type="submit" value="Add">
</form>
<hr>
<h2>List of Teachers</h2>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${teachers}" var="teacher">
            <tr>
                <td>${teacher.id}</td>
                <td>${teacher.name}</td>
                <td>${teacher.age}</td>
                <td><a href="TeacherServlet?action=edit&id=${teacher.id}">Edit</a></td>
                <td><a href="TeacherServlet?action=delete&id=${teacher.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
    

</body>
</html>