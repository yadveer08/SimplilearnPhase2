package com.simplilearn.dao;

import com.simplilearn.entities.Classs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClassDAO {
    private SessionFactory sessionFactory;

    public ClassDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Classs> getAllClasses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Classs", Classs.class).getResultList();
        }
    }

    public Classs getClassById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Classs.class, id);
        }
    }

    public void saveOrUpdateClass(Classs clazz) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(clazz);
            session.getTransaction().commit();
        }
    }

    public void deleteClass(Classs clazz) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(clazz);
            session.getTransaction().commit();
        }
    }
}
