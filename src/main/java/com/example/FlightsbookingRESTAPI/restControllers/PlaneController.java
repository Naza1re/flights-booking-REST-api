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

import java.util.List;

@RestController
@RequestMapping("/{airport_name}/planes")
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @PostMapping("/add-plane")
    public HttpStatus addPlane(@PathVariable("airport_name") String name, @RequestBody Plane plane) throws AirportNotFoundException, ResponseNotFoundException {
        return planeService.addPlane(name,plane);
    }
    @DeleteMapping("/delete-plane")
    public HttpStatus deletePlane(@PathVariable String airport_name,Long id) throws AirportNotFoundException {
        return planeService.delete(airport_name,id);
    }
    @GetMapping("/all-planes")
    public List<Plane> getAllPlanes(@PathVariable String airport_name) throws AirportNotFoundException {
        return planeService.getAllPlanes(airport_name);
    }



}
