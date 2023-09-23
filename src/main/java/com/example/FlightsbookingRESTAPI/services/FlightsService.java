package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightsService {

    @Autowired
    private  FlightRepository flightRepository;


    @Autowired
    public FlightsService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public  void save(Flights flights){
        flightRepository.save(flights);
    }



}
