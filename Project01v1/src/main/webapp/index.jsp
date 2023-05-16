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
	
	<br/><br/>
	<form method="post" action="login-submit.jsp">
		<fieldset>
			<legend>Login Form For Administrator</legend>
			<br/>
			Username: <input type="text" name="username" id="username" /> <br/><br/>
			Password: <input type="password" name="password" id="password" /> <br/><br/>
			
			<input type="submit" value="Login"/>
		</fieldset>
	</form>
	
	<jsp:include page="footer.jsp" />
</body>
</html>