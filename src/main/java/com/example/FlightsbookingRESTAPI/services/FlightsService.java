package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    @SneakyThrows
    public ResponseEntity<List<Flights>> getAllFlightOfAirport(String airport){
        Optional<Airport> opt_airport = airportRepository.findByName(airport);
        if(opt_airport.isPresent()){
            return new ResponseEntity<List<Flights>>(opt_airport.get().getFlightsList(), HttpStatus.OK);
        }
        else
                throw new ResponseNotFoundException("airport '" + airport + "' not found.");
    }

    public Flights save(Flights flights) {
        flightRepository.save(flights);
        return flights;
    }

    public List<Flights> findAll() {
        return flightRepository.findAll();
    }
    public Flights getFlightsById(Long id){
        return flightRepository.getReferenceById(id);
    }

}
