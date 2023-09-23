package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightsService {

    private static FlightRepository flightRepository;

    public static void save(Flights flights){
        flightRepository.save(flights);
    }



}
