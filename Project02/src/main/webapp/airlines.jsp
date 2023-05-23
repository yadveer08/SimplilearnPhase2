<%@page import="com.company.entities.Airline"%>
<%@page import="java.util.List"%>
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
	
		Add Airline: 
	<form action="storeAirlines.jsp">
		<input type="text" name="airline" placeholder="Airline name.." />
		<input type="submit" value="Submit" />
	</form>
	
	<h2>Master List of Airlines</h2>
	
	<%  
		DatabaseManager dbManager = new DatabaseManager();
		List<Airline> airlines = dbManager.getAirlines();
	%>
	
	<table >
	  <tr>
	    <th>Airlines</th>
	  </tr>
	<% 
	for(Airline airline: airlines) { %>
	  <tr>
	    <td>
			* <%= airline.getName() %>
	    </td>
	  </tr>
	<% }%>
	</table>
	
	
	<jsp:include page="footer.jsp" />

</body>
</html>