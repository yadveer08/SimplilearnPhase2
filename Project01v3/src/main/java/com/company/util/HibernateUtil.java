package com.company.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.entities.LoginDetail;
import com.company.entities.SchoolClass;
import com.company.entities.Student;
import com.company.entities.Subject;
import com.company.entities.Teacher;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {

		if (sessionFactory != null) {
			return sessionFactory;
		}

		// STEP 1: Create Configuration Object
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(LoginDetail.class)
										.addAnnotatedClass(Subject.class)
										.addAnnotatedClass(Student.class)
										.addAnnotatedClass(SchoolClass.class)
										.addAnnotatedClass(Teacher.class);
		
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
}
