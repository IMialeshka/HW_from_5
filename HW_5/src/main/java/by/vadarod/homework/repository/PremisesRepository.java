package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PremisesRepository {

    public void addPremises(Premises premises)
    {
        SessionFactory sessionFactory =  HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(premises);
        session.getTransaction().commit();
        session.close();
    }

    public Premises copyPremises(long id, short idPremises)
    {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Premises premises = session.get(Premises.class, id);
        session.detach(premises);
        premises.setIdNumber(idPremises);
        premises.setId(null);
        session.getTransaction().begin();
        session.persist(premises);
        session.getTransaction().commit();
        session.close();
        return premises;
    }

    public Premises uppPricePremises(long id, double price)
    {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Premises premises = session.get(Premises.class, id);
        premises.setPrice(price);
        session.getTransaction().begin();
        session.merge(premises);
        session.getTransaction().commit();
        session.close();
        return premises;
    }

    public static List<PremisesMore>  getAllPremisesMore()
    {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<PremisesMore>  premisesMoreList = session.createQuery("from PremisesMore").getResultList();
        session.close();
        return premisesMoreList;
    }

    public void dellPremises(Premises premises)
    {
        SessionFactory sessionFactory =  HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.remove(premises);
        session.getTransaction().commit();
        session.close();
    }

    public Map<String, Double> findCostForClient() {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c.idNumber as idNumber, c.name as name, (price/maxPeople) as priceForClient from Premises c");
         List<Object[]> resultList = query.getResultList();
        session.close();
        Map<String, Double> costForClient = new HashMap<>();

        for (Object[] result : resultList) {
            costForClient.put(result[0].toString()  + " " + result[1].toString(), Double.parseDouble(result[2].toString()));
        }
        return costForClient;
    }

    public Short findTotalCountVisitors() {
        EntityManager em = HibernateConnection.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Short> criteriaQuery = criteriaBuilder.createQuery(Short.class);
        Root<Premises> root = criteriaQuery.from(Premises.class);
        criteriaQuery.select(criteriaBuilder.sum(root.get("maxPeople")));
        return em.createQuery(criteriaQuery).getSingleResult();
    }

    public List<Premises> findPremisesByAge(int yare) {
        EntityManager em = HibernateConnection.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<SignUp> criteriaQuery = criteriaBuilder.createQuery(SignUp.class);
        Root<SignUp> root = criteriaQuery.from(SignUp.class);
        Join<SignUp, User> joinUser = root.join("user");
        criteriaQuery.where(criteriaBuilder.lt(joinUser.get("yearOfBirth"), yare));
        return em.createQuery(criteriaQuery).getResultList().stream().map(p -> p.getPremises()).distinct().collect(Collectors.toList());
    }

}
