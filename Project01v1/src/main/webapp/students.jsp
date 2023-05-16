<%@page import="java.util.List"%>
<%@page import="com.simplilearn.entities.Student"%>
<%@page import="com.simplilearn.entities.SchoolClass"%>
<%@page import="com.simplilearn.util.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navigation.jsp" />
	
	<%
		DatabaseManager dbManager = new DatabaseManager();
		List<SchoolClass> classes = dbManager.getClasses();
	%>
	
	<form action="storeStudent.jsp" method="post">
		First name: <input type="text" name="name" placeholder="name.." /><br/>
		Address: <input type="text" name="address" placeholder="address.." /><br/>
		Assign Class: 
		<select name="class">
			<%for(SchoolClass sc: classes) { %>
				<option value="<%= sc.getClass_id() %>"> <%= sc.getName() %> </option>
			<%} %>
		</select>
		<br/>
		<input type="submit" value="Submit"/>
	</form>
	
		
	<h2>Master List of Students</h2>
	
		<table >
	  <tr>
	    <th> Name</th>
	    <th> Address</th>
	    <th> Class</th>
	  </tr>
	<% List<Student> students = dbManager.getStudents();
	for(Student student: students) { %>
	  <tr>
	    <td><%=student.getName() %></td>
	    <td><%=student.getAddress() %></td>
	    <td><%=student.getSchoolClass().getName() %></td>
	  </tr>
	<% }%>
	</table>

	
		<jsp:include page="footer.jsp" />
</body>
</html>