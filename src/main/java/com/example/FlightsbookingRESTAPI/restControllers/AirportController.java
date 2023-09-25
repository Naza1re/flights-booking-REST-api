package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.services.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    private final AirportRepository airportRepository;

    public AirportController(AirportService airportService, AirportRepository airportRepository) {
        this.airportService = airportService;
        this.airportRepository = airportRepository;
    }

    @PostMapping("/add-airport")
    public Airport addAirport(@RequestBody Airport airport){
        return airportService.save(airport);
    }
    @GetMapping("/get-all")
    public List<Airport> getAllAirports(){
        return airportService.findAll();
    }
    @PostMapping("/getAllByName")
    public List<Airport> getAllByName(@RequestBody String name){
        return airportService.finsAllByName(name);
    }
    @GetMapping("/getAllByName/{id}")
    public Airport getAirportById(@PathVariable Long id){
        return airportService.findAirportById(id);
    }
    @PostMapping("/getAllByCity")
    public List<Airport> getAirportByName(@RequestBody String city){
        return airportService.findAirportsByCity(city);
    }

}
