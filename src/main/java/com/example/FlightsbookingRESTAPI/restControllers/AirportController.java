package com.example.FlightsbookingRESTAPI.restControllers;


import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.services.AirportService;

import org.springframework.http.HttpStatus;
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
    public HttpStatus addAirport(@RequestBody Airport airport){
        return airportService.save(airport);
    }

    @GetMapping("/{airport_name}")
    public Airport getAirport(@PathVariable("airport_name") String name){
        return airportService.findByName(name);
    }
    @DeleteMapping(path = "/{airport_name}")
    public HttpStatus deleteAirport(@PathVariable("airport_name") String airportName) throws ResponseNotFoundException {
        return airportService.deleteAirportByName(airportName);
    }
    @GetMapping("/all-airports")
    public List<Airport> getAllAirport(){
        return airportService.getAllAirports();
    }
    // almost done



}
