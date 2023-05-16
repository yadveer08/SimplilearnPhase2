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
		String username= (String)session.getAttribute("username");
	
		if(username==null) {
			throw new ServletException("Invalid user access on profile page!");
		}
	%>
	
	<jsp:include page="header.jsp" /> <br/>
	
		<h2 style="color: green;"> Hellow User <%=username %></h2>
		
		<nav>
			<a href="list-employee.jsp">List Employee</a> <br/>
			<a href="add-employee.jsp">Add Employee</a> <br/>
		</nav>
	
	<jsp:include page="footer.jsp" /> <br/>
	
</body>
</html>