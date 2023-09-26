package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private static AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }





     public HttpStatus save(Airport airport){
        airportRepository.save(airport);
        return HttpStatus.CREATED;
    }
    public void delete(Airport airport){
        airportRepository.delete(airport);
    }
    public Airport findByName(String name){
        List<Airport> airports = airportRepository.findAirportByName(name);
        if (!airports.isEmpty()) {
            return airports.get(0);
        } else {
            return null;
        }
    }

    public Airport findAirportById(Long id){
        return airportRepository.findAllById(id);
    }

    public HttpStatus deleteAirportByName(String airportName) throws ResponseNotFoundException {
        Optional<Airport> opt_airport = airportRepository.findByName(airportName);
        if(opt_airport.isPresent()){
            delete(opt_airport.get());
            return HttpStatus.OK;
        }else
            throw new ResponseNotFoundException("airport '" + airportName + "' not found.");
    }
}
