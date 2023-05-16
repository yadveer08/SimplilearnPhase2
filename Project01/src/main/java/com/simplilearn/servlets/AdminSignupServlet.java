package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.AdminDetail;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AdminSignupServlet
 */
@WebServlet("/admin-signup")
public class AdminSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting details from client
		String admin = request.getParameter("admin");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		
		// Checking details
		if (!admin.equals("") && !password.equals("") && !confirm.equals("")) {
			if (password.equals(confirm)) {
				if (password.length()>3) {
					
					// Prepare Object
					AdminDetail details = new AdminDetail();
					details.setAdminName(admin);
					details.setPassword(password);

					// STEP 1 : Gets SessionFactory object
					SessionFactory sf = HibernateUtil.buildSessionFactory();

					// STEP 2: Open Session
					Session session = sf.openSession();

					// STEP 3: Save entity into DB
					Transaction tx = session.beginTransaction();
					session.save(details);
					tx.commit();

					// STEP 4: Close Session
					session.close();
					
					// Going back to the Login page
					response.sendRedirect("index.html");					
				} else {
					errorMessage(request, response, "Password has to be atleast 4 characters!");
				}
			} else {
				errorMessage(request, response, "Password Doesn't Match!");
			}
		} else {
			errorMessage(request, response, "Details Cannot be Empty!");
		}
		
	}
	// to send back error message if requirements doesn't match
	public static void errorMessage(HttpServletRequest request, HttpServletResponse response, String message) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String rs = "<html><body>";
		
		rs+= "<div align='center'><br/><SPAN style='color:red'>"+message+"</SPAN></div>";
		request.getRequestDispatcher("signup.html").include(request, response);
		
		rs+= "</body></html>";
		out.println(rs);
	}

}
