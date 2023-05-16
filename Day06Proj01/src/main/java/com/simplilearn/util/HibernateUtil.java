package com.simplilearn.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.EProduct;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	
	private HibernateUtil() {} // making default constructor private
	
	public static SessionFactory buildSessionFactory() {
		// below statement will make it Singleton class
		if (sessionFactory!=null) return sessionFactory;
		
		// STEP 1: Create Configuration Object
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(EProduct.class); // adding Entity
	
		return cfg.buildSessionFactory(); // returning session Object
	}
}
