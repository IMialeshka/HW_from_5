package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Client;
import by.vadarod.homework.entity.Premises;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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
}
