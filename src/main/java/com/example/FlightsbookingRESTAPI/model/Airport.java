package com.example.FlightsbookingRESTAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "airport")
public class Airport {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;

    @Column(name = "flights")
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Flights> flightsList;

}
