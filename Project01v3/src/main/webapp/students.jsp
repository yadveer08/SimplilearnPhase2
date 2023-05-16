<%@page import="java.util.List"%>
<%@page import="com.company.entities.Student"%>
<%@page import="com.company.entities.SchoolClass"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>
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
	
	<%
		DatabaseManager dbManager = new DatabaseManager();
		List<SchoolClass> classes = dbManager.getClasses();
	%>
	
	<form action="storeStudent.jsp" method="post">
		Name: <input type="text" name="name" placeholder="name.." /><br/>
		Age: <input type="text" name="age" placeholder="name.." /><br/>
		Address: <input type="text" name="address" placeholder="address.." /><br/>
		Assign Class: 
		<select name="class">
			<%for(SchoolClass sc: classes) { %>
				<option value="<%= sc.getSchoolClassId() %>"> <%= sc.getName() %> </option>
			<%} %>
		</select>
		<br/>
		<input type="submit" value="Submit"/>
	</form>
	
	
	<h2>Master List of Students</h2>
	
		<table >
	  <tr>
	    <th>Name</th>
	    <th>Age</th>
	    <th>Address</th>
	    <th>Class</th>
	  </tr>
	<% List<Student> students = dbManager.getStudents();
	if(students != null) {
	for(Student student: students) { %>
	  <tr>
	    <td><%=student.getName() %></td>
	    <td><%=student.getAge() %></td>
	    <td><%=student.getAddress() %></td>
	    <td><%=student.getSchoolClass().getName() %></td>
	  </tr>
	  <%} %>
	<% }%>
	</table>

	
		<jsp:include page="footer.jsp" />
</body>
</html>