
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.entities.Subject"%>
<%@page import="com.simplilearn.util.DatabaseManager"%>
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
		
		for(String subject: subjectsSet) { %>
		* <%=subject%> <br/>
	<% } %>

	
	<jsp:include page="footer.jsp" />

</body>
</html>