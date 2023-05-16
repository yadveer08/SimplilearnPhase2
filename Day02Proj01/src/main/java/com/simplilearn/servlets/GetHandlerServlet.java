package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetHandlerServlet
 */
@WebServlet("/getHandler")
public class GetHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// requesting GET parameter name from client
		String name = request.getParameter("name");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("This GET request served from servlet");
		pw.println(name);
		pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		PrintWriter pw = response.getWriter();
		String rs = "<html>";
		rs += "<body>";
		rs += "<h3>Form</h3>";
		rs += "Name: " + name + "<br>";
		rs += "Address: " + address;
		
		rs += "</body>";
		rs += "</html>";
		pw.print(rs);
	}

}
