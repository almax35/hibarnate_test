package org.example.service;

import org.example.dao.CarDao;
import org.example.models.Car;

public class CarService {
    public CarService() {
    }

    public void addCar(Car car){
        CarDao.addCar(car);
    }
    public void deleteCar(int id){
        CarDao.deleteCar(id);
    }

    public void updateCar(Car car){
        CarDao.updateCar(car);
    }
    public void printCars(){
        CarDao.printCar();
    }
}
