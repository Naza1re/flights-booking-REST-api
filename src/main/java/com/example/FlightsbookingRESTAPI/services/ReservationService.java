package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Reservation;
import com.example.FlightsbookingRESTAPI.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository repository;
    @Autowired
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Reservation saveReservation(Reservation reservation){
        return repository.save(reservation);
    }
    public List<Reservation> getAllReservations(){
        return repository.findAll();
    }
}
