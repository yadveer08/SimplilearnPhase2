<%@page import="com.company.entities.Place"%>
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
	
		String name = request.getParameter("place");
		if(name!="" && name!=null) {
			
			Place place = new Place();
			place.setName(name);
			dbManager.addPlace(place);
		}
		else {
			 throw new NullPointerException("Empty Fileds!");
		}
		request.getRequestDispatcher("places.jsp").forward(request, response);
	%>

</body>
</html>