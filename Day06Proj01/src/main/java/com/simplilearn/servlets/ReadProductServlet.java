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

import com.simplilearn.entity.EProduct;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadProductServlet
 */
@WebServlet("/read-product")
public class ReadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String rs = "<html><body>";
		
		// STEP 1: Gets Session Factory object
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		// STEP 2: Open Session object
		Session session = sf.openSession();
		
		// STEP 3: Use Query API (HQL) to list result from DB
		List<EProduct> products = session.createQuery(" from EProduct ").list();
		
		if (products!=null && products.size()>0) {
			rs+= "<h1> Product List :- </h1>";
			rs+= "<style> table,td,th {border:2px solid green; } </style>";
			rs+= "<table>";
			rs+= "<tr>";
			rs+= "<th> Product ID </th>";
			rs+= "<th> Product Name </th>";
			rs+= "<th> Product price </th>";
			rs+= "</tr>";
			
			
			for(EProduct p : products) {
				rs+= "<tr>";
				rs+= "<td>"+p.getId()+"</td>";
				rs+= "<td>"+p.getName()+"</td>";
				rs+= "<td>"+p.getPrice()+"</td>";
				rs+= "</tr>";
			}
					
			rs+= "</table>";	
		} else {
			rs+= "<p> There are no records in the DB, Please add first!";
		}
		
		rs+= "</body></html>";
		pw.println(rs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
