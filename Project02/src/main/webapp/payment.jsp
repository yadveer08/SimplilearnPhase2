<%@page import="com.company.entities.Flight"%>
<%@page import="com.company.entities.Passenger"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		DatabaseManager dbManager = new DatabaseManager();
		List<Passenger> passengers = new ArrayList<Passenger>();
		
		String personsString = (String) session.getAttribute("persons");
		int persons = 0;
		if(personsString!=null && personsString!="") {
			persons = Integer.parseInt(personsString);			
		}
		String flight_id = (String) session.getAttribute("flight_id");
		Flight flight = null;
		if(flight_id!=null && flight_id!="") {
			flight = dbManager.getFlight(Long.parseLong(flight_id));		
		}
		
		for(int i=0; i<persons; i++) {
			String name = request.getParameter("name"+(i+1));
			int age =  Integer.parseInt( request.getParameter("age"+(i+1)));
			String email = request.getParameter("email"+(i+1));
			String phone = request.getParameter("phone"+(i+1));
			
			passengers.add(new Passenger(name, age, email, phone, flight));
		}
	%>
	
	<h2>Confirm your details And Pay</h2>
	
	<% int count = 1;
		if(passengers!=null && passengers.size()>0) {
			for(Passenger p: passengers) { %>
				<h3>Passenger <%=count %>: </h3>
				Name: <%= p.getName() %><br>
				Age: <%= p.getAge() %><br>
				Email: <%= p.getEmail() %><br>
				Phone: <%= p.getPhone() %><br>
				<%count++; %>
	<% 		}
		}
		
		session.setAttribute("passengers", passengers);
	%>
	
	<h2> Total Amout: Rs. <%= (flight.getTicketPrice() * passengers.size() ) %></h2>
	
	<form action="storePayment.jsp" method="POST">
	    Cardholder Name: <input type="text" name="cardholder" required><br><br>
	
	    Card Number: <input type="text" name="card_number" required><br><br>
	
	    Expiry Date: <input type="text" name="expiry_date" placeholder="MM/YYYY" required><br><br>
	
	    CVV: <input type="text" name="cvv" required><br><br>
	
	    Payment Method:<br>
	    <input type="radio" name="payment_method" value="credit" checked>
	    Credit Card<br>
	    <input type="radio" name="payment_method" value="debit" checked>
	    Debit Card<br>
	    <input type="radio" name="payment_method" value="paypal">
	    PayPal<br>
	    
	    <input type="submit" value="Confirm & Pay">
  	</form>
  

	

</body>
</html>