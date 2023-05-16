package com.simplilearn.dao;

import com.simplilearn.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TeacherDAO {
    private SessionFactory sessionFactory;

    public TeacherDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Teacher> getAllTeachers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Teacher", Teacher.class).getResultList();
        }
    }

    public Teacher getTeacherById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Teacher.class, id);
        }
    }

    public void saveOrUpdateTeacher(Teacher teacher) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(teacher);
            session.getTransaction().commit();
        }
    }

    public void deleteTeacher(Teacher teacher) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(teacher);
            session.getTransaction().commit();
        }
    }
}

