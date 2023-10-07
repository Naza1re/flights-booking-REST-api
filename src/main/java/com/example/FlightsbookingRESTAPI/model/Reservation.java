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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "flights_id")
    private Flights flights;

    @Column(name = "passenger")
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Passenger> passengerList;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation() {

    }
}
