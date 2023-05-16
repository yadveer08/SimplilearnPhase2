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

import com.simplilearn.entity.AdminDetail;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		
		PrintWriter out = response.getWriter();
		String rs = "<html><body>";
		
		
		String admin = request.getParameter("admin");
		String password = request.getParameter("password");
		
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		List<AdminDetail> details = session.createQuery("from AdminDetail").list();
		
		if (details.size()>0) {
			for (AdminDetail detail : details) {
				if (admin.equals(detail.getAdminName()) && password.equals(detail.getPassword())) {
					response.sendRedirect("home.html");
				} else {
					rs+= "<h1>Invalid Details!</h1>";
				}
			}
			
		} else {
			rs+= "<h1>Please setup Admin Login Details!</h1>";
			rs+= "<p>(You need to Signup first)</p>";
		}
		
		rs+= "</body></html>";
		out.println(rs);
		
		
		

//		
//		
//		
//		if (admin != null && !admin.equals("") && password != null && !password.equals("")) {
//			if (admin.equals(ad.get(0).getAdminName()) && password.equals(ad.get(0).getPassword())) {
//				System.out.println("Valid Details");
//				
//			} else {
//				request.getRequestDispatcher("index.html").include(request, response);
//				rs+= "<div align='center'><SPAN style='color:red'>Invalid Details!</SPAN></div>";
//			}
//			
//		} else {
//			request.getRequestDispatcher("index.html").include(request, response);
//			rs+= "<div align='center'><SPAN style='color:red'>Details cannot be empty!</SPAN></div>";
//		}
//		

	}

}
