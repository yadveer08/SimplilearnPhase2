<%@page import="com.company.entities.Place"%>
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
	
		Add Place/Location: 
	<form action="storePlaces.jsp">
		<input type="text" name="place" placeholder="place name.." />
		<input type="submit" value="Submit" />
	</form>
	
	<h2>Master List of Places</h2>
	
	<%  
		DatabaseManager dbManager = new DatabaseManager();
		List<Place> placesList = dbManager.getPlaces();
	%>
	
	<table >
	  <tr>
	    <th>Places</th>
	  </tr>
	<% 
	for(Place place: placesList) { %>
	  <tr>
	    <td>
			* <%= place.getName() %>
	    </td>
	  </tr>
	<% }%>
	</table>
	
	
	<jsp:include page="footer.jsp" />

</body>
</html>