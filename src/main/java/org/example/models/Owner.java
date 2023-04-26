package org.example.models;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="owner", schema="new_schema")
public class Owner {
   @Id
   @GeneratedValue
   @Column (name="idOwner")
   private int idOwner;
   @Column (name="name")
    private String name;
   @Column(name="birthday")
    private Date birthday;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Car> autos;



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "idOwner=" + idOwner +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", autos=" + autos +
                '}';
    }
    public Owner() {

    }

    public Owner(int idOwner, String name, Date birthday) {
        this.idOwner = idOwner;
        this.name = name;
        this.birthday = birthday;
    }
}
