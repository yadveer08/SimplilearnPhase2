<%@page import="com.company.dao.TeacherDAO"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="com.company.entities.Subject"%>
<%@page import="com.company.entities.Teacher"%>
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
	
	<%	
		DatabaseManager dbManager = new DatabaseManager();
		Set<Subject> subjects = new HashSet<Subject>(dbManager.getSubjects());
	%>
	
	<form action="storeTeacher.jsp" method="post">
		Name: <input type="text" name="name" placeholder="name.." /><br/>
		Age: <input type="text" name="age" placeholder="age" /><br/>
		Phone no.: <input type="text" name="phone" placeholder="phone number.." /><br/>
		Address : <input type="text" name="address" placeholder="address.." /><br/>
		Assign Subjects:
			<select name="sub1">
				<%for(Subject subject: subjects) { %>
					<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
				<%} %>
			</select>
			<select name="sub2">
				<%for(Subject subject: subjects) { %>
					<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
				<%} %>
			</select>
		<br/>
		<input type="submit" value="Add"/>
	</form>
	
		
	<h2>Master List of Teachers</h2>
	
	<table >
	  <tr>
	    <th>Name</th>
	    <th>Age</th>
	    <th>Phone number</th>
	    <th>Address</th>
	    <th>Subjects</th>
	  </tr>
	<% List<Teacher> teachers = dbManager.getTeachers();
		TeacherDAO tDAO = new TeacherDAO();
	for(Teacher teacher: teachers) { %>
	  <tr>
	    <td><%=teacher.getName()%></td>
	    <td><%=teacher.getAge()%></td>	    
	    <td><%=teacher.getPhone()%></td>
	    <td><%=teacher.getAddress()%></td>
	    <td>
	    	<% 
	    		List<Subject> subs = tDAO.getSubjectsFromTeacher(teacher.getTeacherId());
	    	%>
	    	<% if(subs!=null && subs.size()>0) { %>
				<%for(Subject sub: subs){ %>
					<%=sub.getName() + ", " %>
				<%} %>
	    	<% } %>
	    </td>
	  </tr>
	<% }%>
	</table>

	
		<jsp:include page="footer.jsp" />
</body>
</html>