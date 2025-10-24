package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateJavaConfig;
import by.vadarod.homework.entity.SignUp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SignUpRepository {
    public void addSignUp(SignUp signUp)
    {
        SessionFactory sessionFactory =  HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(signUp);
        session.getTransaction().commit();
        session.close();
    }

}
