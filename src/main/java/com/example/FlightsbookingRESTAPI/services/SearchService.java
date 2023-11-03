package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private  final FlightRepository flightRepository;

    public SearchService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public  List<Flights> getFlightsByCity(String city){
        return flightRepository.getAllFlightsByArrival(city);
    }
}
