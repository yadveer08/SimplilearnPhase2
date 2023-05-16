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

    <h1>Class Report</h1>
    <hr>
    <h2>Select Class</h2>
    <form action="ClassReportServlet" method="POST">
        <select name="classId">
            <c:forEach items="${classes}" var="class">
                <option value="${class.id}">${class.name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Generate Report">
    </form>

</body>
</html>