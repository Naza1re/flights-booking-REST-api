package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.PlaneNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.model.Passenger;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import com.example.FlightsbookingRESTAPI.repository.PassengerRepository;
import com.example.FlightsbookingRESTAPI.repository.PlaneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
    private final PlaneRepository planeRepository;

    private final FlightRepository flightRepository;

    public PassengerService(PassengerRepository passengerRepository, PlaneRepository planeRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
        this.flightRepository = flightRepository;
    }

    public HttpStatus removePassengersFromPlane(long id) throws PlaneNotFoundException {
        Optional<Plane> opt_plane = planeRepository.findById(id);

        if (opt_plane.isPresent()) {
            List<Passenger> passengers = opt_plane.get().getPassengerList();
            for (int i = 0; i < passengers.size(); i++) {
                passengers.get(i).setReservation(null);
                passengerRepository.save(passengers.get(i));
                return HttpStatus.OK;
            }
        } else

            throw new PlaneNotFoundException("plane with id '" + id + "' not found");
        return HttpStatus.BAD_GATEWAY;

    }

}
