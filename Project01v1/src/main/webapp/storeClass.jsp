<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.simplilearn.util.DatabaseManager"%>
<%@page import="com.simplilearn.entities.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.entities.SchoolClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		DatabaseManager dbManager = new DatabaseManager();
		String className = request.getParameter("className");
		Set<String> subjectsSet_ids = new HashSet<String>();// for unique
		
		// getting subject ids as unique
		String[] subNames = { "sub1", "sub2", "sub3", "sub4", "sub5", "sub6", "sub7", "sub8"};
		for (String subName : subNames) {
			if(subName != null && !subName.isEmpty()) {
				String sub_id = request.getParameter(subName);
				subjectsSet_ids.add(sub_id);
			}
		}
		
		//getting subjects from db
		List<Subject> subjectList = new ArrayList<Subject>();
		for(String sub_id: subjectsSet_ids){
			// adding subject in subjectList
			if(sub_id != null && sub_id != "") {
				subjectList.add(dbManager.getSubject(Long.parseLong(sub_id)));	
			}
		}
		
		
		SchoolClass sc;
	    
	    if (className == null || className.isEmpty()) {
	        throw new NullPointerException("Name is empty!");
	    } else {
	        sc = new SchoolClass();
	        sc.setName(className);
	        // Rest of your code
	        
	        try {
	            dbManager.addClassWithSubjects(sc, subjectList);
	        } catch (Exception e) {
	            throw new ServletException(": Error adding class", e);
	        }
	    } 
		request.getRequestDispatcher("classes.jsp").forward(request, response);
	%>

</body>
</html>
