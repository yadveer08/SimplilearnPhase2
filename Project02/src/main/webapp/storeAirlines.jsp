<%@page import="com.company.entities.Airline"%>
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
	
		String name = request.getParameter("airline");
		if(name!="" && name!=null) {
			
			Airline airline = new Airline();
			airline.setName(name);
			dbManager.addAirline(airline);
		}
		else {
			 throw new NullPointerException("Empty Fileds!");
		}
		request.getRequestDispatcher("airlines.jsp").forward(request, response);
	%>

</body>
</html>