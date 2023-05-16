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
import com.company.entities.Student;

public class SchoolClassDAO {
	
	
	private SessionFactory sessionFactory;
    
    public SchoolClassDAO() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }
	
//	
//    public List<Subject> getSubjectsFromClass(int id) {
//    	SchoolClass schoolClass = dbManager.getSchoolClass(id);
//    	return schoolClass.getSubjects();
//    }
//    
    public List<Subject> getSubjectsFromClass(int classId) {
    	Session session = sessionFactory.openSession();
    	List<Subject> subjects = null;
    	try {
    	    Transaction transaction = session.beginTransaction();
    	    // Fetch SchoolClass instance
    	    SchoolClass schoolClass = session.get(SchoolClass.class, classId);
    	    // Load students collection
    	    Hibernate.initialize(schoolClass.getSubjects());
    	    // Access students collection
    	    subjects = schoolClass.getSubjects();
    	    // Commit transaction
    	    transaction.commit();
    	} finally {
    	    session.close();
    	}
    	return subjects;
    }
    public List<Student> getStudentsFromClass(int classId) {
    	Session session = sessionFactory.openSession();
    	List<Student> students = null;
    	try {
    		Transaction transaction = session.beginTransaction();
    		// Fetch SchoolClass instance
    		SchoolClass schoolClass = session.get(SchoolClass.class, classId);
    		// Load students collection
    		Hibernate.initialize(schoolClass.getStudents());
    		// Access students collection
    		students = schoolClass.getStudents();
    		// Commit transaction
    		transaction.commit();
    	} finally {
    		session.close();
    	}
    	return students;
    }
    public List<Teacher> getTeachersFromClass(int classId) {
    	Session session = sessionFactory.openSession();
    	List<Teacher> teachers = null;
    	try {
    		Transaction transaction = session.beginTransaction();
    		// Fetch SchoolClass instance
    		SchoolClass schoolClass = session.get(SchoolClass.class, classId);
    		// Load students collection
    		Hibernate.initialize(schoolClass.getTeachers());
    		// Access students collection
    		teachers = schoolClass.getTeachers();
    		// Commit transaction
    		transaction.commit();
    	} finally {
    		session.close();
    	}
    	return teachers;
    }
    
}
