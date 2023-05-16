
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="com.company.entities.Subject"%>
<%@page import="com.company.util.DatabaseManager"%>
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
	
	Add Subject: 
	<form action="storeSubject.jsp">
		<input type="text" name="subject" placeholder="subject name.." />
		<input type="submit" value="Submit" />
	</form>
	
	<h2>Master List of Subjects</h2>
	
	<%  
		DatabaseManager dbManager = new DatabaseManager();
		List<Subject> subjectsList = dbManager.getSubjects();
		Set<String> subjectsSet = new HashSet<String>();
		
		for(Subject subject: subjectsList) {
			subjectsSet.add(subject.getName());
		}
	%>
	
	<table >
	  <tr>
	    <th>Subject</th>
	  </tr>
	<% 
	for(String subject: subjectsSet) { %>
	  <tr>
	    <td>
			<%= subject %>
	    </td>
	  </tr>
	<% }%>
	</table>

	
	<jsp:include page="footer.jsp" />

</body>
</html>