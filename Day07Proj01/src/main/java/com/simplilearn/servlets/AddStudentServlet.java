package com.simplilearn.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("add-student.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Prepare Object
		Student student = getStudent(request);

		// STEP 1 : Gets SessionFactory object
		SessionFactory sf = HibernateUtil.buildSessionFactory();

		// STEP 2: Open Session
		Session session = sf.openSession();

		// STEP 3: Save entity into DB
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();

		// STEP 4: Close Session
		session.close();
		
		response.sendRedirect("read-student");
	}

	private Student getStudent(HttpServletRequest request) {
		Student student = new Student();

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");

		String phone_1 = request.getParameter("phone_1");
		String phone_type_1 = request.getParameter("phone_type_1");

		String phone_2 = request.getParameter("phone_2");
		String phone_type_2 = request.getParameter("phone_type_2");

		String phone_3 = request.getParameter("phone_3");
		String phone_type_3 = request.getParameter("phone_type_3");

		List<PhoneNumber> phones = new ArrayList<>();

		PhoneNumber phoneNumber1 = new PhoneNumber();
		phoneNumber1.setPhoneNumber(phone_1);
		phoneNumber1.setPhoneType(phone_type_1);
		phoneNumber1.setStudent(student);

		PhoneNumber phoneNumber2 = new PhoneNumber();
		phoneNumber2.setPhoneNumber(phone_2);
		phoneNumber2.setPhoneType(phone_type_2);
		phoneNumber2.setStudent(student);

		PhoneNumber phoneNumber3 = new PhoneNumber();
		phoneNumber3.setPhoneNumber(phone_3);
		phoneNumber3.setPhoneType(phone_type_3);
		phoneNumber3.setStudent(student);

		phones.add(phoneNumber1);
		phones.add(phoneNumber2);
		phones.add(phoneNumber3);

		student.setFname(firstName);
		student.setLname(lastName);
		student.setPhones(phones);
		return student;
	}

}
