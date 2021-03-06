package hibernate.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration();
                sessionFactory = config.configure().buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return sessionFactory;
    }
}
