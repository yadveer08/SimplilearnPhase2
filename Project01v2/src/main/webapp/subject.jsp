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

    <h1>Subject Management System</h1>
    <hr>
    <h2>Add Subject</h2>
    <form action="SubjectServlet" method="POST">
        <label>Name:</label> <input type="text" name="name"><br>
        <label>Description:</label> <input type="text" name="description"><br>
        <label>Class:</label> 
        <select name="classId">
            <c:forEach items="${classes}" var="class">
                <option value="${class.id}">${class.name}</option>
            </c:forEach>
        </select><br>
        <label>Teacher:</label> 
        <select name="teacherId">
            <c:forEach items="${teachers}" var="teacher">
                <option value="${teacher.id}">${teacher.name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Add">
    </form>
    <hr>
    <h2>List of Subjects</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Class</th>
                <th>Teacher</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${subjects}" var="subject">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td>
                    <td>${subject.description}</td>
                    <td>${subject.classs.name}</td>
                    <td>${subject.teacher.name}</td>
                    <td><a href="SubjectServlet?action=edit&id=${subject.id}">Edit</a></td>
                    <td><a href="SubjectServlet?action=delete&id=${subject.id}">Delete</a></td>
                    </tr>
	        </c:forEach>
	    </tbody>
	</table>

</body>
</html>