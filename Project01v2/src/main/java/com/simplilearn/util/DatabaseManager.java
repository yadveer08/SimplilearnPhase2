package com.simplilearn.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entities.Subject;
import com.simplilearn.entities.Student;
import com.simplilearn.entities.Teacher;
import com.simplilearn.entities.Classs;

public class DatabaseManager {
    private SessionFactory sessionFactory;
    
    public DatabaseManager() {
		this.sessionFactory = HibernateUtil.buildSessionFactory();
    }
    
    public void addSubject(Subject subject) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(subject);
        session.getTransaction().commit();
        session.close();
    }
    
    public void addTeacher(Teacher teacher) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }
    
    public void addClass(Classs cls) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cls);
        session.getTransaction().commit();
        session.close();
    }
    
    public void addStudent(Student student) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(student);
    	session.getTransaction().commit();
    	session.close();
    }
    public void updateSubject(Subject subject) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.saveOrUpdate(subject);
    	session.getTransaction().commit();
    	session.close();
    }
    
    public void updateTeacher(Teacher teacher) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.saveOrUpdate(teacher);
    	session.getTransaction().commit();
    	session.close();
    }
    
    public void updateClass(Classs cls) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.saveOrUpdate(cls);
    	session.getTransaction().commit();
    	session.close();
    }
    
    public void updateStudent(Student student) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.saveOrUpdate(student);
    	session.getTransaction().commit();
    	session.close();
    }
    
    public List<Student> getStudents() {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }
    public List<Subject> getSubjects() {
    	Session session = sessionFactory.openSession();
    	List<Subject> subjects = session.createQuery("from Subject", Subject.class).list();
    	session.close();
    	return subjects;
    }
    public List<Classs> getClasses() {
    	Session session = sessionFactory.openSession();
    	List<Classs> classess = session.createQuery("from Classs", Classs.class).list();
    	session.close();
    	return classess;
    }
    public List<Teacher> getTeachers() {
    	Session session = sessionFactory.openSession();
    	List<Teacher> teachers = session.createQuery("from Teacher", Teacher.class).list();
    	session.close();
    	return teachers;
    }
}
