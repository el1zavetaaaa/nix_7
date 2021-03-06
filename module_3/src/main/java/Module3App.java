import controller.JDBCController;
import controller.JPAController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HibernateSessionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Module3App {
    private static final Logger logger = LoggerFactory.getLogger(Module3App.class);


    public static void main(String[] args) {
        Map<String, String> arguments = readArguments(args);
        Properties props = loadProperties();
        switch (arguments.get("type")) {
            case "1": {
                jpaRun();
                break;
            }
            case "2": {
                jdbcRun(arguments, props);
                break;
            }
            default: {
                System.err.println("Wrong type parameter pleas repeat");
            }
        }
    }

    private static void jdbcRun(Map<String, String> arguments, Properties props) {
        String url = props.getProperty("url");
        try (Connection connection = DriverManager.getConnection(url, arguments.get("user"), arguments.get("password"));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            JDBCController secondVariant = new JDBCController(connection, arguments.get("email"));
            secondVariant.run(bufferedReader);
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private static void jpaRun() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                JPAController jpaController = new JPAController(session, "test@email.com");

                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    jpaController.run(bufferedReader);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }

            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    private static Map<String, String> readArguments(String[] args) {
        Map<String, String> properties = new HashMap<>();
        properties.put("user", args[0]);
        properties.put("password", args[1]);
        properties.put("email", args[2]);
        properties.put("type", args[3]);
        return properties;
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = Module3App.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }
}
