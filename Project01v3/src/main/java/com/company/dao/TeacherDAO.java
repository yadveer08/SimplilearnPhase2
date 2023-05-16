package com.company.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.company.entities.SchoolClass;
import com.company.entities.Subject;
import com.company.entities.Teacher;
import com.company.util.HibernateUtil;

public class TeacherDAO {
	
	private SessionFactory sessionFactory;
  
	public TeacherDAO() {
		this.sessionFactory = HibernateUtil.buildSessionFactory();
	}
	
    public List<Subject> getSubjectsFromTeacher(int teacherId) {
    	Session session = sessionFactory.openSession();
    	List<Subject> subjects = null;
    	try {
    	    Transaction transaction = session.beginTransaction();
    	    // Fetch SchoolClass instance
    	    Teacher teacher = session.get(Teacher.class, teacherId);
    	    // Load students collection
    	    Hibernate.initialize(teacher.getSubjects());
    	    // Access students collection
    	    subjects = teacher.getSubjects();
    	    // Commit transaction
    	    transaction.commit();
    	} finally {
    	    session.close();
    	}
    	return subjects;
    }
    
    public void addSchoolClassesToTeacher(List<String> classId, String teacherId) {
    	for (String cId : classId) {
			addSchoolClassToTeacher( Integer.parseInt(cId), Integer.parseInt(teacherId));
		}
    }
    
	public void addSchoolClassToTeacher(int classId, int teacherId) {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
	        
	        SchoolClass schoolClass = session.get(SchoolClass.class, classId);
	        Teacher teacher = session.get(Teacher.class, teacherId);
	        
	        teacher.getSchoolClasses().add(schoolClass);
	        
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
