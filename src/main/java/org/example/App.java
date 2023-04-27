package org.example;

import org.example.dao.CarDao;
import org.example.dao.OwnerDao;
import org.example.models.Car;
import org.example.models.Owner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Owner owner=OwnerDao.findOwnerById(3);
        CarDao.addCar(new Car(10000,owner));
    }
}
