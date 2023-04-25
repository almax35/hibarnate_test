package org.example.models;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOwner")
    @Column(name="idOwner")
    private Owner owner;


    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", cost=" + cost +
                ", owner=" + owner.getName() +
                '}';
    }
}
