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

    <h1>Class Report Result</h1>
    <hr>
    <h2>${class.name} Report</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Subject</th>
                <th>Teacher</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${subjects}" var="subject">
                <tr>
                    <td>${subject.name}</td>
                    <td>${subject.teacher.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>