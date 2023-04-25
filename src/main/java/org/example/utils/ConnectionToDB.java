package org.example.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionToDB {
    private static Connection connection;


    public static Connection getConnection() {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("D:\\IntelliJ IDEA 2022.3.1\\Hibernate_test\\src\\main\\java\\prooprties\\properties.properties"));
            connection = DriverManager.getConnection(
                    prop.getProperty("url"), prop.getProperty("login"), prop.getProperty("password"));
        } catch (SQLException e) {

        } catch (IOException e) {

        }
        return connection;
    }
}
