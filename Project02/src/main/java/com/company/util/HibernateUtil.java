package com.company.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.entities.Airline;
import com.company.entities.Flight;
import com.company.entities.LoginDetail;
import com.company.entities.Passenger;
import com.company.entities.Place;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {

		if (sessionFactory != null) {
			return sessionFactory;
		}

		// STEP 1: Create Configuration Object
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(LoginDetail.class)
										.addAnnotatedClass(Place.class)
										.addAnnotatedClass(Airline.class)
										.addAnnotatedClass(Flight.class)
										.addAnnotatedClass(Passenger.class);
		
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
}
