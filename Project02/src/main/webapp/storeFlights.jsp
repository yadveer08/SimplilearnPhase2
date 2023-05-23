<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.company.entities.Flight"%>
<%@page import="com.company.entities.Airline"%>
<%@page import="com.company.entities.Place"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		DatabaseManager dbManager = new DatabaseManager();
		String source_id = request.getParameter("source");
		String destination_id = request.getParameter("destination");
		String airline_id = request.getParameter("airline");
		String dateString = request.getParameter("date");
		String timeString = request.getParameter("time");
		String price = request.getParameter("price");			
		
		Place source = null, destination = null;
		Airline airline = null;
		Double ticketPrice = 0.00;
		
		if(source_id==null || source_id=="" || destination_id==null || destination_id=="" || airline_id==null
				|| airline_id=="" || price==null || price=="" ) {
			throw new NullPointerException("Empty Fileds!");
		}
		
		if(source_id == destination_id) {
			throw new Exception("'Source' And 'Destination' should not be same.");		
		}
		
		source = dbManager.getPlace(Long.parseLong(source_id));	
		destination = dbManager.getPlace(Long.parseLong(destination_id));
		
		if(dateString==null || dateString=="" || timeString==null || timeString=="") {
			throw new NullPointerException("Empty Date and Time Fields!");
		}
		
		LocalDate date = LocalDate.parse(dateString);
		LocalTime time = LocalTime.parse(timeString);
		
		airline = dbManager.getAirline(Long.parseLong(airline_id));
		ticketPrice = Double.parseDouble(price);

	    Flight flight = new Flight();
		flight.setSource(source);
		flight.setDestination(destination);
		flight.setAirline(airline);
		flight.setDateField(date);
		flight.setTimeField(time);
		flight.setTicketPrice(ticketPrice);
	    dbManager.addFlight(flight);
	    
	    
		request.getRequestDispatcher("flights.jsp").forward(request, response);
	%>

</body>
</html>
