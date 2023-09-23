package com.example.FlightsbookingRESTAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "flights")
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "departure_date")
    private String departure_date;

    @Column(name = "departure_time")
    private String departure_time;

    @Column(name = "arrival")
    private String arrival;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    private List<Passenger> passenger;

    private Reservation reservation;

}
