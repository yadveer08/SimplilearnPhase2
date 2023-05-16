package com.simplilearn.dao;

import com.simplilearn.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAO {
    private SessionFactory sessionFactory;

    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).getResultList();
        }
    }

    public Student getStudentById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        }
    }

    public void saveOrUpdateStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }

    public void deleteStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }
}



