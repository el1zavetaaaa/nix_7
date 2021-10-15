package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSessionFactory {
    private static final Logger loggerInfo = LoggerFactory.getLogger("info");

    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        loggerInfo.info("Getting session factory");
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();
            return configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
