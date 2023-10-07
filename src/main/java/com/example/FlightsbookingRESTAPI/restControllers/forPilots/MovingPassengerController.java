package com.example.FlightsbookingRESTAPI.restControllers.forPilots;

import com.example.FlightsbookingRESTAPI.exeptions.FlightNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PlaneNotFoundException;
import com.example.FlightsbookingRESTAPI.services.FlightsService;
import com.example.FlightsbookingRESTAPI.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/forPilots")
@RestController

public class MovingPassengerController {


    private final PassengerService passengerService;
    private final FlightsService flightsService;

    public MovingPassengerController(PassengerService passengerService, FlightsService flightsService) {
        this.passengerService = passengerService;
        this.flightsService = flightsService;
    }

    @PostMapping("/removePassengersFromPlane/{id}")
    public HttpStatus removePassengerFromPlane(@PathVariable long id) throws PlaneNotFoundException {
        return passengerService.removePassengersFromPlane(id);
    }
    @PostMapping("/startFlight/{id}")
    public HttpStatus startFlight(@PathVariable long id) throws FlightNotFoundException {
        return flightsService.startFlight(id);
    }


}
