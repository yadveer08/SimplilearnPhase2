<%@page import="com.simplilearn.util.HibernateUtil"%>
<%@page import="com.simplilearn.entities.Student"%>
<%@page import="com.simplilearn.util.DatabaseManager"%>
<%@page import="com.simplilearn.entities.Subject"%>
<%@page import="com.simplilearn.entities.SchoolClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="navigation.jsp" />

	<h2>Master List of all the classes</h2>
	
	<%	
		DatabaseManager dbManager = new DatabaseManager();
		List<SchoolClass> classes = dbManager.getClasses(); 
	%>
	
	<table >
	  <tr>
	    <th> Class</th>
	    <th> Total Subjects</th>
	    <th> Total Students</th>
	  </tr>
	<%for(SchoolClass sc: classes) { %>
	  <tr>
	    <td><%=sc.getName()%></td>
	    <td>
	    	<%  List<Subject> subs = sc.getSubjects(); %>
	    	<% if(subs != null) { %>
	    		<%= subs.size() %>
	    	<%} %>
	     </td>
	    <td>
	    	<% 
	    		List<Student> studs = dbManager.getStudentsFromClass(sc.getClass_id());  %>
	    	<% if(studs != null){ %>
	    		<%= studs.size() %>
	    	<%} %>
	     </td>
	  </tr>
	<% }%>
	</table>
	
	<jsp:include page="footer.jsp" />

</body>
</html>