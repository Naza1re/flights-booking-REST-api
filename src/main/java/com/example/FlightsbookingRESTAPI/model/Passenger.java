package com.example.FlightsbookingRESTAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat")
    private int seat;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;


    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private  Reservation reservation;

    @Column(name = "free")
    private boolean free;

    public boolean isFree(){
        return this.free;
    }



}
