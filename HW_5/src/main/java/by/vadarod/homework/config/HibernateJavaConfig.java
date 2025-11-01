package by.vadarod.homework.config;

import by.vadarod.homework.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateJavaConfig {
    private static final Configuration config;
    private static final StandardServiceRegistryBuilder serviceRegistry;
    private static SessionFactory sessionFactory;

    static {
        Properties props = new Properties();
        props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/HW_5?currentSchema=schema_hw");
        props.put("hibernate.connection.username", "postgres");
        props.put("hibernate.connection.password", "19850515");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.format_sql", "true");
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        props.put("hibernate.cache.use_second_level_cache", "true");
        props.put("hibernate.cache.use_query_cache", "true");
        props.put("hibernate.cache.region.factory_class", "org.hibernate.cache.jcache.internal.JCacheRegionFactory");
        props.put("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
        props.put("hibernate.javax.cache.uri", "META-INF/config/ehcache.xml");
        props.put(" hibernate.generate_statistics", "true");
        config = new Configuration();
        config.addAnnotatedClass(Client.class);
        config.addAnnotatedClass(Service.class);
        config.addAnnotatedClass(Premises.class);
        config.addAnnotatedClass(PremisesMore.class);
        //config.addAnnotatedClass(ClientPremium.class);
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(Visit.class);
        config.addAnnotatedClass(SignUp.class);
        serviceRegistry = new StandardServiceRegistryBuilder();
        serviceRegistry.applySettings(props);
    }

    public static SessionFactory getSessionFactory() {
        if  (sessionFactory == null) {
            sessionFactory = config.buildSessionFactory(serviceRegistry.build());
        }
        return sessionFactory;
    }
}
