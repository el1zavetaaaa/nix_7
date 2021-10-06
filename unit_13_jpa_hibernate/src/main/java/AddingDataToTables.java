import dao.AddingDataUsingHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddingDataToTables {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            AddingDataUsingHibernate addingDataUsingHibernate = new AddingDataUsingHibernate();
            try {
                session.getTransaction().begin();
                addingDataUsingHibernate.initialization(session);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
