package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class SubjectsServlet
 */
@WebServlet("/subjects-page")
public class SubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String rs = "<html><body>";
		
		request.getRequestDispatcher("add-subject.html").include(request, response);
		
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		List<Subject> subjects = session.createQuery("from Subject").list();
		rs+= "<br/>";
		rs+= "<table>";
		rs+= "<tr>";
		rs+= "<th>Subject Name</th>";
		rs+= "</tr>";
		if (subjects != null && subjects.size() > 0) {
			for (Subject subject : subjects) {
				rs+= "<tr>";
					rs+= "<td>"+subject.getName()+"</td>";
				rs+= "</tr>";
			}
		}
		rs+= "</table";
		rs+= "</body></html>";
		out.println(rs);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectName = request.getParameter("name");
		
		Subject subject = new Subject();
		subject.setName(subjectName);
		
		// STEP 1 : Gets SessionFactory object
		SessionFactory sf = HibernateUtil.buildSessionFactory();

		// STEP 2: Open Session
		Session session = sf.openSession();

		// STEP 3: Save entity into DB
		Transaction tx = session.beginTransaction();
		session.save(subject);
		tx.commit();

		// STEP 4: Close Session
		session.close();
		
		// Going back to the Login page
		response.sendRedirect("subjects-page");
	}

}
