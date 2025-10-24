package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.Client;
import by.vadarod.homework.entity.ClientPremium;
import by.vadarod.homework.entity.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientRepository {

    public static void addClient(Client client)
    {
        EntityManager em = HibernateConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Client>  getAllClients()
    {
        EntityManager em = HibernateConnection.getEntityManager();
        List clients = em.createQuery("from Client").getResultList();
        em.close();
        return clients;
    }

    public Client  getIdClient(long id)
    {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public static void dellClient(long id)
    {
        EntityManager em = HibernateConnection.getEntityManager();
        Client client = em.find(Client.class,id);
        em.getTransaction().begin();
        em.remove(client);
        em.getTransaction().commit();
        em.close();
    }

    public static void changeStatus(long id, Status newStatus)
    {
        EntityManager em = HibernateConnection.getEntityManager();
        Client client = em.find(Client.class,id);
        em.getTransaction().begin();
        client.setStatus(newStatus);
        em.getTransaction().commit();
        em.close();
    }

    public List<ClientPremium>  getAllClientPremium()
    {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<ClientPremium>  premiumList = session.createQuery("from ClientPremium").getResultList();
        session.close();
        return premiumList;
    }

    public void addClientUser(Client client) {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(client);
        session.getTransaction().commit();
        session.close();

    }

    public List<Client>  findClientByName(String name) {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from ClientsEntity c where c.name = :name");
        query.setParameter("name", name);
        List<Client> clients = query.getResultList();
        session.close();
        return clients;
    }

}
