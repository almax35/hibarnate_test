package org.example.utils;
import org.example.models.Car;
import org.example.models.Owner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class MySession {
    public  static SessionFactory getConfiguration() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("D:\\IntelliJ IDEA 2022.3.1\\Hibernate_test\\src\\main\\java\\prooprties\\hibernate.properties"));

        SessionFactory sessionFactory = new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();

      return sessionFactory;
    }
}
