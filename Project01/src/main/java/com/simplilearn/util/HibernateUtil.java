package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.AdminDetail;
import com.simplilearn.entity.Subject;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {

		if (sessionFactory != null) {
			return sessionFactory;
		}

		// STEP 1: Create Configuration Object
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(AdminDetail.class)
										.addAnnotatedClass(Subject.class);
		
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
}
