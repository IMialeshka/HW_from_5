package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ServiceRepository {

    public void addService(Service service)
    {
        SessionFactory sessionFactory =  HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(service);
        session.getTransaction().commit();
        session.close();
    }
}
