<%@page import="java.util.List"%>
<%@page import="com.company.dao.LoginDetailDAO"%>
<%@page import="com.company.entities.LoginDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="errorLogin.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<%
	// Getting login details from user
		String username = request.getParameter("username");
		String password = request.getParameter("password");
			
		// checking if details are empty or null
		if (username == null || password == null || username.equals("") || password.equals(""))
			throw new ServletException(":: Mandatory Parameters are missing ::");
		
		// getting login details from db
		List<LoginDetail> details = LoginDetailDAO.getLoginDetails();
			
		if (details == null || details.size() < 1){
			// checking default credentials
			if (username.equals("admin") && password.equals("admin")) {
				response.sendRedirect("places.jsp");
			} else {
				throw new ServletException(":: Invalid Credentials ::");
			}
		} else {
			// checking db credentials
			String dbUsername = details.get(0).getLoginId();
			String dbPassword = details.get(0).getPassword();
			if (dbUsername.equals(username) && dbPassword.equals(password))	{
				response.sendRedirect("places.jsp");
			} else {
				throw new ServletException(":: Invalid Credentials ::");
			}
				
		}
	%>
	
	<jsp:include page="footer.jsp" />

</body>
</html>