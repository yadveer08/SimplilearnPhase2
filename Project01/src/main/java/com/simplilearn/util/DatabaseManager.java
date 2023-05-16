package com.simplilearn.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Teacher;
import com.simplilearn.entity.SchoolClass;

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
    
    public void addClass(SchoolClass cls) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cls);
        session.getTransaction().commit();
        session.close();
    }
    
    public void assignSubjectToClass(Subject subject, SchoolClass cls) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        cls.getSubjects().add(subject);
        session.update(cls);
        session.getTransaction().commit();
        session.close();
    }
    
    public void assignTeacherToSubjectInClass(Teacher teacher, Subject subject, SchoolClass cls) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        cls.getTeacherSubjectMap().put(subject, teacher);
        session.update(cls);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Student> getStudents() {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }
}
