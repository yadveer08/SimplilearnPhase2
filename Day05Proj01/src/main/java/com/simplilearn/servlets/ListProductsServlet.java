package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.db.DbUtil;

/**
 * Servlet implementation class ListProductsServlet
 */
@WebServlet("/listProducts")
public class ListProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String r = "<html><body>";
		r+= "<table>";
		r+= "<tr>";
		r+= "<tr>";
		r+= "<th>Id</td>";
		r+= "<th>Name</td>";
		r+= "<th>Price</td>";
		r+= "<th>Date-Added</td>";
		r+= "</tr>";
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/phase2";
		String username = "root";
		String password = "Y@komail0572";
		try {
			DbUtil dbObj = new DbUtil(jdbcUrl, username, password);
			
			// STEP 1&2: Gets connection object
			Connection con = dbObj.getConnection();
			
			// STEP 3: Create Statement Object
			Statement stmt = con.createStatement();
			
			// STEP 4: Execute Query
			ResultSet rs = stmt.executeQuery("select * from eproduct");
			
			// STEP 5: Iterate ResultSet
			while (rs.next()) {
				// 1 2 3 .. is column number.
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				Date date_added = rs.getDate(4);	
				
				r+= "<tr>";
				r+= "<td>"+id+"</td>";
				r+= "<td>"+name+"</td>";
				r+= "<td>"+price+"</td>";
				r+= "<td>"+date_added+"</td>";
				r+= "</tr>";
			}
			
			// STEP 6: Close connection
			dbObj.closeConnection();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		r+= "</table>";
		r+= "</body></html>";
		pw.print(r);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
