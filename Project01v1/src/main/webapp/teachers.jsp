<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="com.simplilearn.entities.Subject"%>
<%@page import="com.simplilearn.entities.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.util.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>
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
		Set<Subject> subjects = new HashSet<Subject>(dbManager.getSubjects());
	%>
	
	<form action="storeTeacher.jsp" method="post">
		First name: <input type="text" name="fname" placeholder="first name.." /><br/>
		Last name: <input type="text" name="lname" placeholder="last name.." /><br/>
		Phone no.: <input type="text" name="phone" placeholder="phone number.." /><br/>
		Assign Subjects: 
			<select name="sub1">
				<%for(Subject subject: subjects) { %>
					<option value="<%= subject.getSubject_id() %>"> <%= subject.getName() %> </option>
				<%} %>
			</select>
			<select name="sub2">
				<%for(Subject subject: subjects) { %>
					<option value="<%= subject.getSubject_id() %>"> <%= subject.getName() %> </option>
				<%} %>
			</select>
		<br/>
		<input type="submit" value="Add"/>
	</form>
	
		
	<h2>Master List of Teachers</h2>
	
		<table  >
	  <tr>
	    <th>| First name</th>
	    <th>| Last name</th>
	    <th>| Phone number</th>
	    <th>| Subjects</th>
	  </tr>
	<% List<Teacher> teachers = dbManager.getTeachers();
	for(Teacher teacher: teachers) { %>
	  <tr>
	    <td><%=teacher.getFname()%></td>
	    <td><%=teacher.getLname()%></td>
	    <td><%=teacher.getPhone()%></td>
	    <td>
	    	<% List<Subject> subs = teacher.getSubjects(); %>
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