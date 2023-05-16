<%@page import="com.company.dao.SchoolClassDAO"%>
<%@page import="com.company.entities.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@page import="com.company.entities.SchoolClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign subjects to a class</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="navigation.jsp" />
	
	<h2>Assign subjects to a class</h2>
	
	<% DatabaseManager dbManager = new DatabaseManager(); %>
	
	<form action="storeClass.jsp" method="post">
	Class: <input type="text" name="className" placeholder="class-name.." /> 
	
	<% List<Subject> subjects = dbManager.getSubjects(); %>
	<br/>
	Subjects:<br/>
		<select name="sub1">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<select name="sub2">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<select name="sub3">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<select name="sub4">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<br/>
		<select name="sub5">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<select name="sub6">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<select name="sub7">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<select name="sub8">
			<option value="none" selected disabled>Select a subject</option>
			<%for(Subject subject: subjects) { %>
				<option value="<%= subject.getSubjectId() %>"> <%= subject.getName() %> </option>
			<%} %>
		</select>
		<p>(At most one class can has 8 subjects.)</p>
	<input type="submit" value="Submit" />
	</form>
	
	
	
	<br/><br/>
	<h2>Master List of Classes</h2>
	
	<%List<SchoolClass> classes = dbManager.getClasses(); %>
	
	<table >
	  <tr>
	    <th> Class</th>
	    <th> Subjects</th>
	  </tr>
	  
	<% SchoolClassDAO scDAO = new SchoolClassDAO();
	for(SchoolClass sc: classes) { %>
	  <tr>
	    <td><%=sc.getName()%></td>
	    <td>
	    	<% List<Subject> subs = scDAO.getSubjectsFromClass(sc.getSchoolClassId()); %>
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
