package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Premises;
import by.vadarod.homework.entity.PremisesMore;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
