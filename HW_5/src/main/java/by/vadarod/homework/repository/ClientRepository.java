package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.entity.Client;
import by.vadarod.homework.entity.Status;
import jakarta.persistence.EntityManager;

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
}
