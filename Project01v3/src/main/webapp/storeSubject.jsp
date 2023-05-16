<%@page import="com.company.entities.Subject"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		DatabaseManager dbManager = new DatabaseManager();
	
		String name = request.getParameter("subject");
		if(name!="" && name!=null) {
			
			Subject subject = new Subject();
			subject.setName(name);
			dbManager.addSubject(subject);
		}
		request.getRequestDispatcher("subjects.jsp").forward(request, response);
	%>

</body>
</html>