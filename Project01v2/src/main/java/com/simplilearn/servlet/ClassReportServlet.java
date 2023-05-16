package com.simplilearn.servlet;

import com.simplilearn.dao.ClassDAO;
import com.simplilearn.entities.Classs;
import com.simplilearn.entities.Subject;
import com.simplilearn.util.HibernateUtil;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Set;

/**
 * Servlet implementation class ClassReportServlet
 */
@WebServlet("/ClassReportServlet")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassDAO classDAO;
	
	public void init() {
        classDAO = new ClassDAO(HibernateUtil.buildSessionFactory());
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classId = Integer.parseInt(request.getParameter("classId"));
        Classs c = classDAO.getClassById(classId);
        Set<Subject> subjects = c.getSubjects();
        request.setAttribute("class", c);
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("class_report_result.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classs> classes = classDAO.getAllClasses();
        request.setAttribute("classes", classes);
        request.getRequestDispatcher("class_report.jsp").forward(request, response);
	}

}
