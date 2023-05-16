<%@page import="com.company.entities.Teacher"%>
<%@page import="com.company.dao.SchoolClassDAO"%>
<%@page import="com.company.util.HibernateUtil"%>
<%@page import="com.company.entities.Student"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@page import="com.company.entities.Subject"%>
<%@page import="com.company.entities.SchoolClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

    <jsp:include page="header.jsp" />
    <jsp:include page="navigation.jsp" />

    <h2>Master List of all the classes</h2>

    <%  
        DatabaseManager dbManager = new DatabaseManager();
        List<SchoolClass> classes = dbManager.getClasses(); 
    %>

    <table>
      <tr>
        <th>Class</th>
        <th>Total Subjects</th>
        <th>Total Students</th>
        <th>Total Teachers</th>
      </tr>
    <%	SchoolClassDAO scDAO = new SchoolClassDAO(); 
    for(SchoolClass sc: classes) {
        List<Subject> subs = scDAO.getSubjectsFromClass(sc.getSchoolClassId());
        List<Student> studs = scDAO.getStudentsFromClass(sc.getSchoolClassId());
        List<Teacher> teachers = scDAO.getTeachersFromClass(sc.getSchoolClassId());
    %>
      <tr>
        <td><%= sc.getName() %></td>
        <td><%= subs != null ? subs.size() : 0 %></td>
        <td><%= studs != null ? studs.size() : 0 %></td>
        <td><%= teachers != null ? teachers.size() : 0 %></td>
      </tr>
    <% } %>
    </table>

    <jsp:include page="footer.jsp" />

</body>
</html>