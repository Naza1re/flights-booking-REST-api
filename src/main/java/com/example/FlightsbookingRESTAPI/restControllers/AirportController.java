package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.services.AirportService;
import com.example.FlightsbookingRESTAPI.services.FlightsService;
import com.example.FlightsbookingRESTAPI.services.PlaneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;
    private final PlaneService planeService;
    private final FlightsService flightsService;

    public AirportController(AirportService airportService, PlaneService planeService, FlightsService flightsService) {
        this.airportService = airportService;
        this.planeService = planeService;
        this.flightsService = flightsService;
    }

    @PostMapping("/add-airport")
    public Airport addAirport(@RequestBody Airport airport){
        return airportService.save(airport);
    }
    @PostMapping("/{id}/addFlight")
    public Flights addFlight(@RequestBody Flights flights, @PathVariable Long id){
        Airport airport = airportService.findAirportById(id);
        flights.setAirport(airport);
        return flightsService.save(flights);
    }
    @PostMapping("/{id}/{id2}/addPlane")
    public Flights addPlaneToFlights(@PathVariable Long id, @PathVariable Long id2){
        Flights flights = flightsService.getFlightsById(id);
        Plane plane = planeService.getPlaneById(id2);
        flights.setPlane(plane);
        return flightsService.save(flights);
    }
    @GetMapping("/{id}")
    public Airport getAirport(@PathVariable Long id){
        return airportService.findAirportById(id);
    }
    @PostMapping("/getAirportByName")
    public Airport getAirportByName(@RequestBody String name){
        return airportService.findByName(name);
    }
    @GetMapping("/getAllByName/{id}")
    public Airport getAirportById(@PathVariable Long id){
        return airportService.findAirportById(id);
    }



}
