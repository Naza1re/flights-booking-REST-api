package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.dto.AirportDTO;
import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.services.AirportService;
import com.example.FlightsbookingRESTAPI.services.FlightsService;
import com.example.FlightsbookingRESTAPI.services.PlaneService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;
    private final PlaneService planeService;
    private final FlightsService flightsService;

    private final ModelMapper modelMapper;

    public AirportController(AirportService airportService, PlaneService planeService, FlightsService flightsService, ModelMapper modelMapper) {
        this.airportService = airportService;
        this.planeService = planeService;
        this.flightsService = flightsService;
        this.modelMapper = modelMapper;
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



}
