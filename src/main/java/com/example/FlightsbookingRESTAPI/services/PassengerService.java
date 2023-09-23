package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
}
