package org.example.dao;

import org.example.models.Car;
import org.example.models.Owner;
import org.example.utils.MySession;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    public static void addCar(Car car){
        try(Session session=MySession.getConfiguration().openSession()){
            Transaction transaction=session.beginTransaction();
            session.persist(car);
            transaction.commit();
            session.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void deleteCar(Integer CarId){
        try(Session session=MySession.getConfiguration().openSession()){
            Transaction trx= session.beginTransaction();
            Car car=(Car) session.find(Car.class, CarId);
            session.remove(car);
            trx.commit();
            session.close();
        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }

    public static void updateCar(Car car){
        try(Session session=MySession.getConfiguration().openSession()){
            Transaction trx= session.beginTransaction();
            session.update(car);
            trx.commit();
            session.close();
        }
        catch (IOException e){

        }

    }
}
