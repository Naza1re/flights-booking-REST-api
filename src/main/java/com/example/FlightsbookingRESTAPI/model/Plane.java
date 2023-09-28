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

    @OneToOne
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;

    public Plane(String name,Pilot pilot){
        this.name = name;

    }
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;


    @JsonIgnore
    @Column(name = "flights")
    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    private List<Flights> flights;




    public Plane() {

    }
}
