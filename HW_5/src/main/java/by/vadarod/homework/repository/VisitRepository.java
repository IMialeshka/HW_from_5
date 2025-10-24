package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class VisitRepository {
    public void addVisit(Visit visit)
    {
        SessionFactory sessionFactory =  HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(visit);
        session.getTransaction().commit();
        session.close();
    }
}
