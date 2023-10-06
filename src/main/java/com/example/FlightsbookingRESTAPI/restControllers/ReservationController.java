package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.exeptions.ReservationNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.UserNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Reservation;
import com.example.FlightsbookingRESTAPI.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{airport_name}/flights/{id}/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/make-reserve/{user_name}")
    HttpStatus makeReserve(@PathVariable Long id,@RequestBody Reservation reservation,@PathVariable String user_name) throws UserNotFoundException {
        return reservationService.makeReserve(id,reservation,user_name);
    }
    @GetMapping("/get-all-reservations")
    List<Reservation> getAllReservations(@PathVariable String airport_name, @PathVariable Long id){
        return reservationService.getAllReservations(airport_name,id);
    }
    @GetMapping("/{id1}")
    public Reservation getReservation(@PathVariable Long id1){
        return reservationService.getReservationById(id1);
    }
    @DeleteMapping("/{id1}/delete")
    public HttpStatus deleteReservation(@PathVariable Long id1) throws ReservationNotFoundException {
        return reservationService.delete(id1);
    }



}
