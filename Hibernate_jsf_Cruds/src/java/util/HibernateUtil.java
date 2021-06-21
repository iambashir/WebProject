/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Sayem R41
 */
public class HibernateUtil {

private static SessionFactory factory;

//static {
//    try {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
//                applySettings(configuration.getProperties());
//        factory = configuration.buildSessionFactory(builder.build());
//        // sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
//    } catch (Throwable ex) {
//        // Log the exception. 
//        System.err.println("Initial SessionFactory creation failed." + ex);
//        throw new ExceptionInInitializerError(ex);
//    }
//}

public static SessionFactory getSessionFactory() {
    try {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        factory = configuration.buildSessionFactory(builder.build());
        // sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
    } catch (Throwable ex) {
        // Log the exception. 
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
    return factory;
}
}
