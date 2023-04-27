package org.example.models;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="owner", schema="new_schema")
public class Owner {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column (name="idOwner")
   private int idOwner;
   @Column (name="name")
    private String name;
   @Column(name="birthday")
    private Date birthday;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Car> cars;



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "idOwner=" + idOwner +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", autos=" + cars +
                '}';
    }
    public Owner() {

    }

    public Owner( String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Owner(int idOwner) {
        this.idOwner = idOwner;
    }
}
