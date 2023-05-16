<%@page import="com.simplilearn.entities.SchoolClass"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.entities.Teacher"%>
<%@page import="com.simplilearn.util.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPage.jsp" %>
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
		DatabaseManager dbManager = new DatabaseManager();
		List<Teacher> teachers = dbManager.getTeachers();
		List<SchoolClass> classes = dbManager.getClasses();
	%>
	
	<form action="assignTeacherToClass.jsp" method="post">
		Select Teacher:
			<select name="teacher">
				<%for(Teacher teacher: teachers) { %>
					<option value="<%= teacher.getTeacher_id() %>"> <%= teacher.getFname() +" "+teacher.getLname() %> </option>
				<%} %>
			</select>
		Assign Class : 
		<select name="class1">
			<%for(SchoolClass sc: classes) { %>
				<option value="<%= sc.getClass_id() %>"> <%= sc.getName() %> </option>
			<%} %>
		</select>
		<select name="class2">
			<%for(SchoolClass sc: classes) { %>
				<option value="<%= sc.getClass_id() %>"> <%= sc.getName() %> </option>
			<%} %>
		</select>
		<select name="class3">
			<%for(SchoolClass sc: classes) { %>
				<option value="<%= sc.getClass_id() %>"> <%= sc.getName() %> </option>
			<%} %>
		</select>
			
		
		<input type="submit" value="Submit"/>
	</form>

	
		<jsp:include page="footer.jsp" />

</body>
</html>