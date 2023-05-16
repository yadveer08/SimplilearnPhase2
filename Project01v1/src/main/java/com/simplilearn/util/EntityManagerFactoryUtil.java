package com.simplilearn.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


// Define a class for creating EntityManagerFactory
public class EntityManagerFactoryUtil {


    public static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
   
}

