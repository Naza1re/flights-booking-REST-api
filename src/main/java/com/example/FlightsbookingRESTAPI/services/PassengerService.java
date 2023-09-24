package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Passenger;
import com.example.FlightsbookingRESTAPI.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger savePassenger(Passenger passenger){
         return passengerRepository.save(passenger);
    }
    public List<Passenger> getAllPassenger(){
        return passengerRepository.findAll();
    }
}
