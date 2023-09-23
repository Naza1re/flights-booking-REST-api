package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/add-airport")
    public Airport addAirport(@RequestBody Airport airport){
        return airportService.save(airport);
    }

    @GetMapping("/get-all")
    public List<Airport> getAllAirports(){
        return airportService.findAll();
    }
}
