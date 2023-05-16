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

  <h1>Student Management System</h1>
    <hr>
    <h2>Add Student</h2>
    <form action="StudentServlet" method="POST">
        <label>Name:</label> <input type="text" name="name"><br>
        <label>Age:</label> <input type="number" name="age"><br>
        <label>Class:</label> 
        <select name="classId">
            <c:forEach items="${classes}" var="class">
                <option value="${class.id}">${class.name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Add">
    </form>
    <hr>
    <h2>List of Students</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Class</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.classs.name}</td>
                    <td><a href="StudentServlet?action=edit&id=${student.id}">Edit</a></td>
                    <td><a href="StudentServlet?action=delete&id=${student.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>