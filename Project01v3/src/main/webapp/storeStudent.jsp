<%@page import="com.company.entities.Student"%>
<%@page import="com.company.entities.SchoolClass"%>
<%@page import="java.util.List"%>
<%@page import="com.company.util.DatabaseManager"%>
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
		String age = request.getParameter("age");
		String address = request.getParameter("address");
	 	String class_id = request.getParameter("class");
		
		
		 if (name.isEmpty() || age.isEmpty() || address.isEmpty() || class_id.isEmpty() ) {
		      throw new NullPointerException("Empty fields!");
		 } 
		 else {
			 // checking age
			 if(Integer.parseInt(age) < 2 && Integer.parseInt(age) > 22 ) {
				 throw new ArithmeticException("Age must be: 2 < age < 22");
			 }
			// getting SchoolClass
			DatabaseManager dbManager = new DatabaseManager();
			SchoolClass schoolClass = dbManager.getSchoolClass(Integer.parseInt(class_id));
			
			// storing teacher to db
			Student student = new Student(name, Integer.parseInt(age), address);
			student.setSchoolClass(schoolClass);
			dbManager.addStudent(student);
			
		}
		request.getRequestDispatcher("students.jsp").forward(request, response);
	%>
</body>
</html>