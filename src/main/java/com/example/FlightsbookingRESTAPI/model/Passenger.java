package com.example.FlightsbookingRESTAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat")
    private int seat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "flights_id")
    private Flights flights;
    @JsonIgnore
    @OneToOne(mappedBy = "passenger")
    private Reservation reservation;

    public Passenger() {

    }
}
