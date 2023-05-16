<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username==null || password ==null || username.equals("") || password.equals("")) {
			throw new ServletException(":: Mandatory Parameters are misssing ::");
		}
		
		if(username.equals("admin") && password.equals("admin")) {
			session.setAttribute("username", username);
			out.print("<h2 style='color:green'> Successfully Logged In!! </h2>");
		} else {
			throw new ServletException(":: Invalid Credentials ::");
		}
	%>
	
</body>
</html>