<%@page import="com.company.dao.SubjectDAO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.company.util.DatabaseManager"%>
<%@page import="com.company.entities.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.company.entities.SchoolClass"%>
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
				subjectList.add(dbManager.getSubject(Integer.parseInt(sub_id)));	
			}
		}
		
		
	    
	    if (className == null || className.isEmpty()) {
	        throw new NullPointerException("Name is empty!");
	    } else {
	    	SchoolClass sc = new SchoolClass();
	        sc.setName(className);
	        sc.setSubjects(subjectList);
	        
	        // adding schoolclass to all the subjects
	        SubjectDAO sDAO = new SubjectDAO();
	        for(Subject sub: subjectList) {
	        	sDAO.addSchoolClassToSubject(sub.getSubjectId(), sc.getSchoolClassId());
	        }
	        dbManager.addClass(sc);
	        
	    } 
		request.getRequestDispatcher("classes.jsp").forward(request, response);
	%>

</body>
</html>
