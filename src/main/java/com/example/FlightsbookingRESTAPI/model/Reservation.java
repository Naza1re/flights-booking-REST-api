package com.example.FlightsbookingRESTAPI.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "User")
public class Reservation {
    @Id
    private Long id;

    @Column(name = "f")
    private List<Flights> flights;

    private Passenger passenger;

    private User user;



}
