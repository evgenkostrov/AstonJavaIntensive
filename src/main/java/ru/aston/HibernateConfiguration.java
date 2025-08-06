package ru.aston;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateConfiguration {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Создать SessionFactory из hibernate.cfg.xml
            return new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            // Убедиться что исключения логируются, поскольку они могут быть потеряны
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        } return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }
}
