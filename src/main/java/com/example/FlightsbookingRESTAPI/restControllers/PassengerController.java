package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.exeptions.FlightNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PassengerNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Passenger;
import com.example.FlightsbookingRESTAPI.model.User;
import com.example.FlightsbookingRESTAPI.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{airport_name}/flights/{id}")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
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
    @PatchMapping("/passenger/{seat_id}")
    public HttpStatus makeReservation(@RequestBody User user, @PathVariable String airport_name, @PathVariable long seat_id, @PathVariable long id) throws PassengerNotFoundException {
        return passengerService.makeReservation(seat_id,user);

    }

}
