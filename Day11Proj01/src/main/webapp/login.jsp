<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<form method="post" action="login-submit.jsp">
		<fieldset>
			<legend>Login Form</legend>
			
			username: <input type="text" name="username" id="username" /> <br/>
			username: <input type="password" name="password" id="password" /> <br/>
			<input type="submit" />
		</fieldset>
	
	</form>
	
	
	<jsp:include page="footer.jsp" />

</body>
</html>