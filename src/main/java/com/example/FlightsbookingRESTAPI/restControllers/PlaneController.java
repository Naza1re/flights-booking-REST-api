package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.dto.FlightsDTO;
import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.services.FlightsService;
import com.example.FlightsbookingRESTAPI.services.PlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{airport_name}/planes")
public class PlaneController {

    private final PlaneService planeService;
    private final FlightsService flightsService;

    public PlaneController(PlaneService planeService, FlightsService flightsService) {
        this.planeService = planeService;
        this.flightsService = flightsService;
    }

    @PostMapping("/add-plane/{type_of_plane}")
    public HttpStatus addPlane(@PathVariable("type_of_plane") String type, @PathVariable("airport_name") String name, @RequestBody Plane plane) throws AirportNotFoundException, ResponseNotFoundException {
        return planeService.addPlane(name,plane,type);
    }
    @DeleteMapping("/delete-plane")
    public HttpStatus deletePlane(@PathVariable String airport_name,Long id) throws AirportNotFoundException {
        return planeService.delete(airport_name,id);


    }



}
