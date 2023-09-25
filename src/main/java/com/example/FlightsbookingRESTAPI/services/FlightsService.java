package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private final AirportRepository airportRepository;


    @Autowired
    public FlightsService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    public Flights save(Flights flights) {
        flightRepository.save(flights);
        return flights;
    }

    public List<Flights> findAll() {
        return flightRepository.findAll();
    }

}
