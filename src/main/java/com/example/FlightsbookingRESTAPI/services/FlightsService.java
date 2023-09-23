package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsService {

    @Autowired
    private  FlightRepository flightRepository;


    @Autowired
    public FlightsService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flights save(Flights flights){
        flightRepository.save(flights);
        return flights;
    }
    public List<Flights> findAll()
    {
        return flightRepository.findAll();
    }



}
