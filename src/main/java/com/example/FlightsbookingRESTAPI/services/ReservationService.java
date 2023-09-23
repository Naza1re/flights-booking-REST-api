package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository repository;
    @Autowired
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }
}