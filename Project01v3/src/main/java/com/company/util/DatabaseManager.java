package com.company.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.company.entities.*;

public class DatabaseManager {
	
	private SessionFactory sessionFactory;
    
    public DatabaseManager() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }
    
    // ADDING OBJECT
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
    
    
    // GETTING SINGLE RECORD
    public Teacher getTeacher(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Teacher teacher = (Teacher) session.get(Teacher.class, id);
            session.getTransaction().commit();
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Subject getSubject(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Subject subject = (Subject) session.get(Subject.class, id);
            session.getTransaction().commit();
            return subject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Student getStudent(int id) {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		Student student = (Student) session.get(Student.class, id);
    		session.getTransaction().commit();
    		return student;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public SchoolClass getSchoolClass(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            SchoolClass schoolClass = (SchoolClass) session.get(SchoolClass.class, id);
            session.getTransaction().commit();
            return schoolClass;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // GETTING LIST OF OBJECTS
    
    public List<Student> getStudents() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student", Student.class).list();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Subject> getSubjects() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Subject> subjects = session.createQuery("from Subject", Subject.class).list();
            session.getTransaction().commit();
            return subjects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<SchoolClass> getClasses() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<SchoolClass> classess = session.createQuery("from SchoolClass", SchoolClass.class).list();
            session.getTransaction().commit();
            return classess;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
}
