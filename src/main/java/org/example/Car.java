package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="car", schema="new_schema")
public class Car {
    @Id
    @GeneratedValue
    @Column(name="idCar")
    private int idCar;
    @Column(name="cost")
    private int cost;
    @Column(name="idOwner")
    private int ownerId;

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", cost=" + cost +
                ", ownerId=" + ownerId +
                '}';
    }
}
