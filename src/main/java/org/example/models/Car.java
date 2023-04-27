package org.example.models;

import jakarta.persistence.*;

@Entity
@Table(name="car", schema="new_schema")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCar")
    private int idCar;
    @Column(name="cost")
    private int cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOwner")
    private Owner owner;


    public Car(int cost, Owner owner) {
        this.cost = cost;
        this.owner = owner;
    }

    public Car() {

    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", cost=" + cost +
                ", owner=" + owner.getName() +
                '}';
    }
}
