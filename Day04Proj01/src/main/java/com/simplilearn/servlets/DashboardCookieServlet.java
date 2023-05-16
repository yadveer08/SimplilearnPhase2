package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashboardCookieServlet
 */
@WebServlet("/dashboardCookie")
public class DashboardCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String rs = "<html><body>";
		// cookie will automatically send by the client browser
		Cookie[] cookies = request.getCookies();// will return array of all cookies
		boolean isUserFound = false;
		// we are just checking is browser has send any cookie
		if(cookies!=null && cookies.length>0) {
			for(Cookie cookie: cookies) {
				// we are checking user_cookie 
				if(cookie.getName().equalsIgnoreCase("user_cookie")) {
					isUserFound = true;
					rs+= "<p>Hello "+cookie.getValue()+"</p><br>";
					rs+= "You have been successfully logged in !";
				}
			}
		}
		if(!isUserFound) {
			rs+="<p>please Login First! </p><br>";
		}
		rs+= "</html></body>";
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
