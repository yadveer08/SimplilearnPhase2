<%@page import="com.company.util.DatabaseManager"%>
<%@page import="com.company.entities.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Information</title>
</head>
<body>
	
	<%
		String flight_id =  request.getParameter("selectedFlightId");
		String persons =  request.getParameter("persons");
		session.setAttribute("persons", persons);
	
		if(flight_id==null || flight_id=="") {
			throw new Exception("Invalid Flight Id or Empty Flight Id!");
		}
		
		session.setAttribute("flight_id", flight_id);
	%>
	
	<form action="payment.jsp" method="post">
		<% for(int i=1; i<=Integer.parseInt(persons); i++) { %>
		
			<h3>Details of Passenger: <%=(i)%></h3>
				Name: <input type="text" name=<%=("name"+i) %> required><br>
				
				Age: <input type="text" name=<%=("age"+i) %> required><br>
				
				Email: <input type="email" name=<%=("email"+i) %> required><br>
				
				Phone: <input type="text" name=<%=("phone"+i) %> required><br>
		        
		<%} %>
		<br><br>
	    <input type="submit" value="Submit">
	</form>
	
</body>
</html>