<%@page import="com.company.entities.Flight"%>
<%@page import="com.company.entities.Airline"%>
<%@page import="com.company.entities.Place"%>
<%@page import="java.util.List"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="navigation.jsp" />
	
	<h2>Add Flight Details</h2>
	
	<% DatabaseManager dbManager = new DatabaseManager(); %>
	
	<form action="storeFlights.jsp" method="post">
	
	<% List<Place> places = dbManager.getPlaces(); %>
	<% List<Airline> airlines = dbManager.getAirlines(); %>
	<br/>
	Source:
		<select name="source" required>
			<option value="none" selected disabled>Select source</option>
			<%for(Place place: places) { %>
				<option value="<%= place.getId() %>"> <%= place.getName() %> </option>
			<%} %>
		</select><br/><br>
		
	Destination:
		<select name="destination" required>
			<option value="none" selected disabled>Select destination</option>
			<%for(Place place: places) { %>
				<option value="<%= place.getId() %>"> <%= place.getName() %> </option>
			<%} %>
		</select><br/><br>
		
	Airline:
		<select name="airline" required>
			<option value="none" selected disabled>Select a subject</option>
			<%for(Airline airline: airlines) { %>
				<option value="<%= airline.getId() %>"> <%= airline.getName() %> </option>
			<%} %>
		</select>
	<p>(Source and Destination must not be same.)</p> <br>
	
	Date: <input type="date" name="date" required><br><br>

    Time: <input type="time" name="time" required><br><br>
	
	Ticket Price: <input type="number" name="price" placeholder="ticket price" min=5000  required/>
	<p>(Ticket price should be more that 5000.)</p>
	<input type="submit" value="Submit" />
	</form>
	
	<br/><br/>
	<h2>Master List of Flights</h2>
	
	<%List<Flight> flights = dbManager.getFlights(); %>
	
	<table>
	  <tr>
	    <th>Source</th>
	    <th>Destination</th>
	    <th>Airline</th>
	    <th>Date</th>
	    <th>Time</th>
	    <th>Ticket price</th>
	  </tr>
	  
	<%
	for(Flight flight: flights) { %>
	  <tr>
	    <td><%=flight.getSource().getName()%></td>
	    <td><%=flight.getDestination().getName()%></td>
	    <td><%=flight.getAirline().getName()%></td>
	    <td><%=flight.getDateField()%></td>
	    <td><%=flight.getTimeField()%></td>
	    <td><%=flight.getTicketPrice()%></td>
	  </tr>
	<% }%>
	</table>
	
	<jsp:include page="footer.jsp" />

</body>
</html>
