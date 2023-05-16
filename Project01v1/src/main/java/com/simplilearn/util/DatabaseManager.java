package com.simplilearn.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entities.SchoolClass;
import com.simplilearn.entities.Student;
import com.simplilearn.entities.Subject;
import com.simplilearn.entities.Teacher;

public class DatabaseManager {
	private SessionFactory sessionFactory;
    private EntityManagerFactory entityManagerFactory;
    
    public DatabaseManager() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        this.entityManagerFactory = EntityManagerFactoryUtil.getEntityManagerFactory();
    }
    
    public void addSubject(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
        }
    }
    
    public void addTeacher(Teacher teacher) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(teacher);
            session.getTransaction().commit();
        }
    }
    
    public void addClass(SchoolClass cls) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(cls);
            session.getTransaction().commit();
        }
    }
    
    public void addStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }
    
    public void updateSubject(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(subject);
            session.getTransaction().commit();
        }
    }
    
    public void updateTeacher(Teacher teacher) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(teacher);
            session.getTransaction().commit();
        }
    }
    
    public void updateClass(SchoolClass cls) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(cls);
            session.getTransaction().commit();
        }
    }
    
    public void updateStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }
    
    public List<Student> getStudents() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student", Student.class).list();
            session.getTransaction().commit();
            return students;
        }
    }
    
    public List<Subject> getSubjects() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Subject> subjects = session.createQuery("from Subject", Subject.class).list();
            session.getTransaction().commit();
            return subjects;
        }
    }
    
    public List<SchoolClass> getClasses() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<SchoolClass> classess = session.createQuery("from SchoolClass", SchoolClass.class).list();
            session.getTransaction().commit();
            return classess;
        }
    }
    
    public List<Teacher> getTeachers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Teacher> teachers = session.createQuery("from Teacher", Teacher.class).list();
            session.getTransaction().commit();
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Teacher getTeacher(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, id);
            session.getTransaction().commit();
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Subject getSubject(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Subject subject = session.get(Subject.class, id);
            session.getTransaction().commit();
            return subject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SchoolClass getSchoolClass(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            SchoolClass schoolClass = session.get(SchoolClass.class, id);
            session.getTransaction().commit();
            return schoolClass;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mergeTeacher(Teacher teacher) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(teacher);
            entityManager.getTransaction().commit();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mergeSchoolClass(SchoolClass schoolClass) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(schoolClass);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Student> getStudentsFromClass(long classId) {
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
	public void addClassWithSubjects(SchoolClass cls, List<Subject> subjects) {
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();

	        // Save the class first
	        session.save(cls);

	        // Set the subjects for the class
	        cls.setSubjects(subjects);

	        // Update the class to save the changes
	        session.update(cls);

	        session.getTransaction().commit();
	    }
	}
	public void setSubjectsToClass(long classId, List<Subject> subjects) {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		SchoolClass schoolClass = session.get(SchoolClass.class, classId); // Replace classId with the id of the school class you want to retrieve
		
		schoolClass.setSubjects(subjects);
		session.close();
	}
	public void getSubjectsFromClass(long classId) {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		SchoolClass schoolClass = session.get(SchoolClass.class, classId); // Replace classId with the id of the school class you want to retrieve
		List<Subject> subjects = schoolClass.getSubjects();
		for (Subject subject : subjects) {
		    System.out.println(subject.getName()); // Print the name of the subject
		}
		session.close();
	}
}
