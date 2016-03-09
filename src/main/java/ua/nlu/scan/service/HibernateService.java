package ua.nlu.scan.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 03.11.15.
 */
@Service
public class HibernateService {
    public HibernateService() {
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory createSessionFactory() {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
