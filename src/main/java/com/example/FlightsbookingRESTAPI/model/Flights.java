package com.example.FlightsbookingRESTAPI.model;

import com.example.FlightsbookingRESTAPI.dto.FlightsDTO;
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
public class Flights extends FlightsDTO {
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

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departure_date='" + departure_date + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", arrival='" + arrival + '\'' +
                ", airport=" + airport +
                ", isActive=" + isActive +
                ", pilot=" + pilot +
                ", plane=" + plane +
                '}';
    }

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;



    public Flights(String name, String departure_date, String departure_time, String arrival) {
        this.name = name;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival = arrival;
    }

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;












}
