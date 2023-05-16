<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.entities.SchoolClass"%>
<%@page import="com.simplilearn.entities.Teacher"%>
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
	    String teacher_id = request.getParameter("teacher");
	    String class1_id = request.getParameter("class1");
	    String class2_id = request.getParameter("class2");
	    String class3_id = request.getParameter("class3");
	    
	    DatabaseManager dbManager = new DatabaseManager();
	    
	    // removing duplicates
	    Set<String> classSet = new HashSet<String>();
	    classSet.add(class1_id);
	    classSet.add(class2_id);
	    classSet.add(class3_id);
	    List<String> classList = new ArrayList<>(classSet);
	
	    
	    // adding classes
	    List<SchoolClass> classes = new ArrayList<SchoolClass>();
	    for(String cl: classList){
	        classes.add(dbManager.getSchoolClass(Long.parseLong(cl)));
	    }
	    
	    // storing data to db
	    Teacher teacher = new Teacher();
	    teacher.setSchoolClasses(classes);
	    dbManager.mergeTeacher(teacher);
	    
	    
	    request.getRequestDispatcher("assignTeacher.jsp").forward(request, response);
	%>
	
	
	

</body>
</html>