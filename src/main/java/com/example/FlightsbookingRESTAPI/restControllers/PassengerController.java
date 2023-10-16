package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.exeptions.FlightNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PassengerNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Passenger;
import com.example.FlightsbookingRESTAPI.services.FlightsService;
import com.example.FlightsbookingRESTAPI.services.PassengerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{airport_name}/flights/{id}")
public class PassengerController {
    private final FlightsService flightsService;
    private final PassengerService passengerService;

    public PassengerController(FlightsService flightsService, PassengerService passengerService) {
        this.flightsService = flightsService;
        this.passengerService = passengerService;
    }
    @GetMapping("/passengers/{seat_id}")
    public Passenger getPassenger(@PathVariable String airport_name, @PathVariable long id, @PathVariable long seat_id) throws FlightNotFoundException, PassengerNotFoundException {
        return passengerService.getPassengerById(seat_id);
    }


    @GetMapping("/passengers")
    public List<Passenger> getAllPassengerOfPlane(@PathVariable String airport_name, @PathVariable long id) throws FlightNotFoundException {
        return passengerService.getAllPassengerOfPlane(id);
    }
}
