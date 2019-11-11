package util;

import Model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static DBHelper dbHelper;

    private DBHelper() {

    }

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    @SuppressWarnings("UnusedDeclaration")
    public static SessionFactory getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", PropertyRead.readProperty("dialect"));
        configuration.setProperty("hibernate.connection.driver_class", PropertyRead.readProperty("driver"));
        configuration.setProperty("hibernate.connection.url", PropertyRead.readProperty("url"));
        configuration.setProperty("hibernate.connection.username", PropertyRead.readProperty("login"));
        configuration.setProperty("hibernate.connection.password", PropertyRead.readProperty("password"));
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            String url = PropertyRead.readProperty("url");
            String password = PropertyRead.readProperty("password");
            String login = PropertyRead.readProperty("login");

            Connection connection = DriverManager.getConnection(url, login, password);
            System.out.println(connection);
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }


}
