package com.example.FlightsbookingRESTAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pilot")
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @JsonIgnore
    @Column(name = "flights")
    @OneToMany(mappedBy = "pilot", cascade = CascadeType.ALL)
    private List<Flights> flightsList;


    public Pilot(String name,int age){
        this.name = name;
        this.age = age;
    }


    public Pilot() {

    }
}
