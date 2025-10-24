package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeRepository {
    public void addEmployee(Employee employee) {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
    }

    public double findMaxSalary() {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select max(c.salary) as maxSalary from EmployeesEntity c");
        double salary = (double)query.getSingleResult();
        session.close();
        return salary;
    }

    public double findMinSalary() {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select min(c.salary) as maxSalary from EmployeesEntity c");
        double salary = (double)query.getSingleResult();
        session.close();
        return salary;
    }

    public double findSalarySumMonth() {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select sum(c.salary) as maxSalary from EmployeesEntity c");
        double salary = (double)query.getSingleResult();
        session.close();
        return salary;
    }

    public List<Employee> findAllEmployees() {
        EntityManager em = HibernateConnection.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }


}
