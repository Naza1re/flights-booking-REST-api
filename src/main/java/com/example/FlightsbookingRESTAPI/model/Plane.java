package com.example.FlightsbookingRESTAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    public Plane(String name,Pilot pilot){
        this.name = name;

    }
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;


    @Column(name = "passenger")
    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    private List<Passenger> passengerList;






    public Plane() {

    }
}
