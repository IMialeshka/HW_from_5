package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Client;
import by.vadarod.homework.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeRepository {
    public void addEmployee(Employee employee) {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();

    }
}
