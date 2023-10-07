package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.FlightNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PilotNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PlaneNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.model.Pilot;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import com.example.FlightsbookingRESTAPI.repository.PilotRepository;
import com.example.FlightsbookingRESTAPI.repository.PlaneRepository;
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
    private final PlaneRepository planeRepository;
    private final PilotRepository pilotRepository;


    @Autowired
    public FlightsService(FlightRepository flightRepository, AirportRepository airportRepository, PlaneRepository planeRepository, PilotRepository pilotRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.planeRepository = planeRepository;
        this.pilotRepository = pilotRepository;
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
    public HttpStatus addFlight(String airportName, Flights flights) throws ResponseNotFoundException {
        Optional<Airport> opt_airport = airportRepository.findByName(airportName);
        if(opt_airport.isPresent()){
            flights.setAirport(opt_airport.get());
            flightRepository.save(flights);
            return HttpStatus.CREATED;

        }else throw new ResponseNotFoundException("airport '" + airportName + "' not found");
    }
    public HttpStatus deleteFlight(Long id) throws ResponseNotFoundException {
        Optional<Flights> opt_flights = flightRepository.findById(id);
        if(opt_flights.isPresent()){
            flightRepository.delete(opt_flights.get());
            return HttpStatus.OK;
        }
        else throw new ResponseNotFoundException("flight '"+opt_flights+"' not found");

    }

    public List<Flights> findAll() {
        return flightRepository.findAll();
    }
    public Flights getFlightsById(Long id){
        return flightRepository.getFlightsById(id);
    }

    public HttpStatus addPlaneToFlight(Long id, Long planeId) throws PlaneNotFoundException {

        Flights flights = flightRepository.getFlightsById(id);

        Optional<Plane> opt_plane = planeRepository.findById(id);
        if(opt_plane.isPresent()){
            flights.setPlane(opt_plane.get());
            flightRepository.save(flights);
            return HttpStatus.OK;
        }
        else throw new PlaneNotFoundException("plane with id : '"+planeId+"'not founde");
    }

    public HttpStatus addPilotToFlight(Long id, Long pilot_id) throws PilotNotFoundException {

        Optional<Pilot> opt_pilot = pilotRepository.getPilotById(pilot_id);
        if(opt_pilot.isPresent()){
            Flights flights = flightRepository.getFlightsById(id);
            flights.setPilot(opt_pilot.get());
            flightRepository.save(flights);
            return HttpStatus.OK;
        }
        else throw new PilotNotFoundException("pilot with id : '"+pilot_id+"'not founde");

    }

    public HttpStatus startFlight(long id) throws FlightNotFoundException {
        Optional<Flights> opt_flight = flightRepository.findById(id);
        if(opt_flight.isPresent()){
            Flights flights = opt_flight.get();
            flights.setActive(true);
            flightRepository.save(flights);
            return HttpStatus.OK;
        }
        else throw new FlightNotFoundException("flight with id '"+ id+"' not found");
    }
}
