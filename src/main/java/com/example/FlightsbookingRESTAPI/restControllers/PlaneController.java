package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.dto.FlightsDTO;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.services.FlightsService;
import com.example.FlightsbookingRESTAPI.services.PlaneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    private final PlaneService planeService;
    private final FlightsService flightsService;

    public PlaneController(PlaneService planeService, FlightsService flightsService) {
        this.planeService = planeService;
        this.flightsService = flightsService;
    }

    @PostMapping("/add-plane")
    public Plane addPlane(@RequestBody Plane plane){
        return planeService.save(plane);
    }

    @PostMapping("/{id}/{id2}/addPlane")
    public FlightsDTO addPlaneToFlights(@PathVariable Long id, @PathVariable Long id2){
        Flights flights = flightsService.getFlightsById(id);
        Plane plane = planeService.getPlaneById(id2);
        flights.setPlane(plane);
        FlightsDTO flightsDTO = new FlightsDTO();
        flightsDTO.setArrival(flights.getArrival());
        flightsDTO.setDeparture_date(flights.getDeparture_date());
        flightsDTO.setDeparture_time(flights.getDeparture_time());
        flightsDTO.setName(flights.getName());
        flightsService.save(flights);
        return flightsDTO;
    }


}
