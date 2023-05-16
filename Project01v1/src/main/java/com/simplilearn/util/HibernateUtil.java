package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entities.LoginDetail;
import com.simplilearn.entities.SchoolClass;
import com.simplilearn.entities.Student;
import com.simplilearn.entities.Subject;
import com.simplilearn.entities.Teacher;

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
