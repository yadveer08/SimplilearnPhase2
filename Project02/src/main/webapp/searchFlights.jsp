<%@page import="javax.xml.transform.Source"%>
<%@page import="com.company.FlightSearchService"%>
<%@page import="com.company.entities.Place"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@page import="com.company.entities.Flight"%>

<%@page import="java.util.List"%>
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

	<% DatabaseManager dbManager = new DatabaseManager(); %>
	<% List<Place> places = dbManager.getPlaces(); %>
	
	<h2>Flight Search</h2>

    <form action="searchFlights.jsp" method="post">
    
        Date of Travel:<input type="date" name="date" ><br><br>

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

        Number of Persons: <input type="number" id="persons" name="persons" min="1" required><br><br>

       	<input type="submit" value="Search Flights">
    </form>
    
    <%
		String date = request.getParameter("date");
		String source_id = request.getParameter("source");
		String destination_id = request.getParameter("destination");
		String persons = request.getParameter("persons");
		
		List<Flight> availableFlights = null;

		
		if(source_id!=null && source_id!="" && destination_id!=null
				&& destination_id!="" && persons!=null && persons!="") {
			
	    	Place source = dbManager.getPlace(Long.parseLong(source_id));
	    	Place destination = dbManager.getPlace(Long.parseLong(destination_id));
			
		    // Call the flight search service to get available flights
		    FlightSearchService flightSearchService = new FlightSearchService();
			if(date!=null && date!="") {
		   		availableFlights = flightSearchService.searchFlights(date, source, destination);
			} else {
		   		availableFlights = flightSearchService.searchFlights(source, destination);
			}
		}
    
	%>
	
	
	
	<br/><br/>
	<h2>Master List of Flights</h2>
	
	<table>
	  <tr>
	    <th>Source</th>
	    <th>Destination</th>
	    <th>Airline</th>
	    <th>Date</th>
	    <th>Time</th>
	    <th>Ticket price</th>
	    <th>Selection</th>
	  </tr>
	  
		<% if(availableFlights!=null) {
				for(Flight flight: availableFlights) { %>
				  <tr>
				    <td><%=flight.getSource().getName()%></td>
				    <td><%=flight.getDestination().getName()%></td>
				    <td><%=flight.getAirline().getName()%></td>
				    <td><%=flight.getDateField()%></td>
				    <td><%=flight.getTimeField()%></td>
				    <td><%=flight.getTicketPrice()%></td>
				    <td>
				        <form action="selectedFlight.jsp" method="post">
                            <input type="hidden" name="selectedFlightId" value="<%= flight.getId() %>">
                            <input type="hidden" name="persons" value="<%= persons %>"> 
                            <input type="submit" value="Select">
                        </form>
				    </td>
				  </tr>
		<%		}
			}%>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>