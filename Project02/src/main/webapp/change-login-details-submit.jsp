<%@page import="com.company.dao.LoginDetailDAO"%>
<%@page import="com.company.entities.LoginDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="change-login-details-error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="navigation.jsp" />
	
	<%
		// Getting login details from user
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String confirm = request.getParameter("confirm");
				
				// checking if details are empty or null
				if (username == null || password == null || username.equals("") || password.equals(""))
			throw new ServletException(":: Mandatory Parameters are missing ::");
				
				if (!password.equals(confirm))
			throw new ServletException(":: Password doesn't match! ::");
				
				if (password.length()<4)
			throw new ServletException(":: Password must be greather than 3 characters!::");
				
				// To delete previous login details 
				LoginDetailDAO.deleteLoginDetails();
				
				// To add new Login Details
				LoginDetail details = new LoginDetail();
				details.setLoginId(username);
				details.setPassword(password);
				LoginDetailDAO.addLoginDetails(details);
				
				response.sendRedirect("index.jsp");
		%>
	
	<jsp:include page="footer.jsp" />

</body>
</html>