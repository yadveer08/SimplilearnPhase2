<%@page import="com.simplilearn.entities.Student"%>
<%@page import="com.simplilearn.entities.SchoolClass"%>
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
		<% 
		String name = request.getParameter("name");
		String address = request.getParameter("address");
	 	String class_id = request.getParameter("class");

		
		 if (name.isEmpty() || address.isEmpty() || class_id.isEmpty() ) {
		        throw new NullPointerException("Empty fields!");
		 } 
		 else {
			
			// getting SchoolClass
			DatabaseManager dbManager = new DatabaseManager();
			SchoolClass schoolClass = dbManager.getSchoolClass(Long.parseLong(class_id));
			
			// storing teacher to db
			Student student = new Student();
			student.setName(name);
			student.setAddress(address);
			student.setSchoolClass(schoolClass);
			dbManager.addStudent(student);
		}
		request.getRequestDispatcher("students.jsp").forward(request, response);
	%>
</body>
</html>