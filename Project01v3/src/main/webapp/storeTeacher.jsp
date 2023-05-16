<%@page import="com.company.dao.SubjectDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.company.entities.Teacher"%>
<%@page import="com.company.entities.Subject"%>
<%@page import="java.util.Set"%>
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
	 	String phone = request.getParameter("phone");
	 	String address = request.getParameter("address");
		String sub1_id = request.getParameter("sub1");
		String sub2_id = request.getParameter("sub2");
		
		 if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || address.isEmpty()
				 ||sub1_id.isEmpty() || sub2_id.isEmpty()) {
		        throw new NullPointerException("Empty fields!");
		 }
		 else {
			 DatabaseManager dbManager = new DatabaseManager();
				// using set to remove duplicate subject_ids
				Set<String> subs = new HashSet<String>();
				subs.add(sub1_id);
				subs.add(sub2_id);
				List<String> uniqueSubs_id = new ArrayList<String> (subs);
				
				
				// getting subjects from database
				List<Subject> subjectsList = new ArrayList<Subject>();
				for (String s: uniqueSubs_id){
					// adding subject to list
					subjectsList.add( dbManager.getSubject(Integer.parseInt(s)));
				}
				
				// storing teacher to db
				Teacher teacher = new Teacher(name, Integer.parseInt(age), phone, address);
				teacher.setSubjects(subjectsList);
				dbManager.addTeacher(teacher);
				
		}
		request.getRequestDispatcher("teachers.jsp").forward(request, response);
	%>

</body>
</html>