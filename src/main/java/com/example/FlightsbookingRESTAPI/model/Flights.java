package com.example.FlightsbookingRESTAPI.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
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

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

}
