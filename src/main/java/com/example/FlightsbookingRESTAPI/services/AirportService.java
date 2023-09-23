package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private static AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }


    public Airport save(Airport airport){
        airportRepository.save(airport);
        return airport;
    }
    public  List<Airport> findAll(){
        return airportRepository.findAll();
    }
}
