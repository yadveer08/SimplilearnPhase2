package com.company.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.company.entities.SchoolClass;
import com.company.entities.Subject;
import com.company.entities.Teacher;
import com.company.util.HibernateUtil;

public class SubjectDAO {
	
	private SessionFactory sessionFactory;
  
	public SubjectDAO() {
		this.sessionFactory = HibernateUtil.buildSessionFactory();
	}
	
	public void addSchoolClassToSubject(int classId, int subjectId) {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
	        
	        SchoolClass schoolClass = session.get(SchoolClass.class, classId);
	        Subject subject = session.get(Subject.class, subjectId);
	        
	        schoolClass.getSubjects().add(subject);
	        
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	public void addTeacherToSubject(int teacherId, int subjectId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Teacher teacher = session.get(Teacher.class, teacherId);
			Subject subject = session.get(Subject.class, subjectId);
			
			teacher.getSubjects().add(subject);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	

}
