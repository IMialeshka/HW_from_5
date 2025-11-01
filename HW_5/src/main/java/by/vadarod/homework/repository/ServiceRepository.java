package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Employee;
import by.vadarod.homework.entity.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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

    public Service findMinPriceService() {
        EntityManager em = HibernateConnection.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Service> criteriaQuery = criteriaBuilder.createQuery(Service.class);
        Root<Service> root = criteriaQuery.from(Service.class);
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("price")));
        return em.createQuery(criteriaQuery).getResultList().stream().findFirst().orElse(null);
    }

    public void checkCache(long id)
    {
        SessionFactory sessionFactory =  HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query queryService = session.createQuery("select s from Service s");
        List<Service> serviceList = queryService.getResultList();

        Query queryEmployee = session.createQuery("select s from EmployeesEntity s");
        List<Employee> employeeList = queryEmployee.getResultList();
        System.out.println("==============find by ID===============");
        Service service = session.find(Service.class, id);
        session.close();
    }

    public void checkCache2Level(long id)
    {
        SessionFactory sessionFactory =  HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query queryService = session.createQuery("select s from Service s");
        List<Service> serviceList = queryService.getResultList();
        session.close();
        System.out.println("==============find by ID in 2 cache===============");
        Session session1 = sessionFactory.openSession();
        Service service = session1.find(Service.class, id);
        session1.close();
    }
}
