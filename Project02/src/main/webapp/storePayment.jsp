<%@page import="com.company.util.DatabaseManager"%>
<%@page import="com.company.entities.Passenger"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	  <% 
	  
	  	DatabaseManager dbManager = new DatabaseManager();	
	  
  		String cardHolder = request.getParameter("cardholder");
  		String cardNumber = request.getParameter("card_number");
  		String expDate = request.getParameter("expiry_date");
  		String cvv = request.getParameter("cvv");
  		String payMethod = request.getParameter("payment_method");
  		
  		List<Passenger> passengers = (List<Passenger>) session.getAttribute("passengers");
  		
  		if(cardHolder!=null && cardHolder!=null && expDate!=null && cvv!=null && payMethod!=null) {
  			if(passengers!=null && passengers.size() > 0) {
	  			for(Passenger p: passengers) {
	  				dbManager.addPassenger(p);
	  			}
	  			
	  			
  			}
  			else {
  				throw new Exception("Empty passengers!");
  			}
  		}
  		
  		request.getRequestDispatcher("searchFlights.jsp").forward(request, response);
  %>

</body>
</html>