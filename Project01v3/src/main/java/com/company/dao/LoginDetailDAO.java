package com.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.company.entities.LoginDetail;
import com.company.util.HibernateUtil;

public class LoginDetailDAO {
	public static void addLoginDetails(LoginDetail e) {
		// STEP 1: Build Session Factory object
		SessionFactory sf = HibernateUtil.buildSessionFactory();

		// STEP 2: Open Session
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		
		session.close();
	}

	public static List<LoginDetail> getLoginDetails() {
		// STEP 1: Build Session Factory object
		SessionFactory sf = HibernateUtil.buildSessionFactory();

		// STEP 2: Open Session
		Session session = sf.openSession();

		// STEP 3: Query DB
		List<LoginDetail> details = session.createQuery(" from LoginDetail ", LoginDetail.class).list();
										
		session.close();
		return details;
	}
	
	public static void deleteLoginDetails() {
		// STEP 1: Build Session Factory object
		SessionFactory sf = HibernateUtil.buildSessionFactory();

		// STEP 2: Open Session
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

		// STEP 3: Query DB
		session.createQuery("delete from LoginDetail").executeUpdate();
		
		tx.commit();

		session.close();
	}
}
