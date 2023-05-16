package com.simplilearn.entity;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.util.HibernateUtil;

public class EmployeeDAO {
	
	public void addEmployee(Employee e) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		Session session = sf.openSession();
		
		session.save(e);
		
		Transaction tx = session.beginTransaction();
		tx.commit();
		
		session.close();
	}
	
	
	public List<Employee> listEmployees() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		Session session = sf.openSession();
		
		List<Employee> employees = session.createQuery(" from Employee ").list();
		
		session.close();
		return employees;
	}
}
