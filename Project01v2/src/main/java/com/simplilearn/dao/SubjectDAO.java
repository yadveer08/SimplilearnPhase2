package com.simplilearn.dao;

import com.simplilearn.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SubjectDAO {
    private SessionFactory sessionFactory;

    public SubjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Subject> getAllSubjects() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Subject", Subject.class).getResultList();
        }
    }

    public Subject getSubjectById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Subject.class, id);
        }
    }

    public void saveOrUpdateSubject(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(subject);
            session.getTransaction().commit();
        }
    }

    public void deleteSubject(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(subject);
            session.getTransaction().commit();
        }
    }
}


