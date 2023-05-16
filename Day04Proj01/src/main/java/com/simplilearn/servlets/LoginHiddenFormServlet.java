package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginHiddenFormServlet
 */
@WebServlet("/loginHiddenForm")
public class LoginHiddenFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHiddenFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String rs = "<html><body>";
		
		String userId = request.getParameter("userId");// getting userId parameter
		rs+= "<form action='dashboardHiddenForm' method='post' >";
		rs+= "<input type='hidden' name='userId' id='userId' value='"+userId+"'/>";
		rs+= "<input type='submit' value='submit' />";
		rs+= "</form>";
		rs+= "<script>document.forms[0].submit();</script>";
		
		rs+= "</body></html>";
		pw.print(rs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
