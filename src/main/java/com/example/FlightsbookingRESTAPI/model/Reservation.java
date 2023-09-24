package com.example.FlightsbookingRESTAPI.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter

@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "flights_id")
    private Flights flights;


    @OneToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation() {

    }
}
