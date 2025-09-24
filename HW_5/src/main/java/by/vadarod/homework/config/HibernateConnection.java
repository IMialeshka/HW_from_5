package by.vadarod.homework.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateConnection {
    private static final EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory( "ClientJPA" );

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
