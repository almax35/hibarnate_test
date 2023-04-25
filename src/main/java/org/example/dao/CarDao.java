package org.example.dao;

import org.example.models.Car;
import org.example.utils.MySession;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;

public class CarDao {
    public static void printCar() {
        try (Session session = MySession.getConfiguration().openSession()) {
            Query<Car> query = session.createQuery(" from Car", Car.class);
            for (Car car: query.list()){
                System.out.println(car.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
