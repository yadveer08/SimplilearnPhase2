<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<jsp:include page="header.jsp" />
	<jsp:include page="navigation.jsp" />
	
	<font color="red"> Error  <%=exception.getMessage() %></font>
	
	<p> Please go to <a href="change-login-details.jsp">Change Password</a> Page to Change Login Details!! </p>
	
	<jsp:include page="footer.jsp" />
	

</body>
</html>