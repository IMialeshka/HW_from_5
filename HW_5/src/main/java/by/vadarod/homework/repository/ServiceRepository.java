package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Employee;
import by.vadarod.homework.entity.Service;
import jakarta.persistence.EntityManager;
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
}
