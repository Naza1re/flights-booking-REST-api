package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.FlightNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PassengerNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PlaneNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.model.Passenger;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.model.User;
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
                passengers.get(i).setUser(null);
                passengerRepository.save(passengers.get(i));
                return HttpStatus.OK;
            }
        } else

            throw new PlaneNotFoundException("plane with id '" + id + "' not found");
        return HttpStatus.BAD_GATEWAY;

    }

    public List<Passenger> getAllPassengerOfPlane(long id) throws FlightNotFoundException {
        Optional<Flights> opt_flights = flightRepository.findById(id);
        if(opt_flights.isPresent()){
            return opt_flights.get().getPlane().getPassengerList();
        }
        else
            throw new FlightNotFoundException("Flight with id '"+id+"' not found");
    }

    public Passenger getPassengerById(long seatId) throws PassengerNotFoundException {
        Optional<Passenger> opt_passenger = passengerRepository.findById(seatId);
        if(opt_passenger.isPresent()){
            return opt_passenger.get();
        }
        else throw new PassengerNotFoundException("seat with id '"+seatId+"' not found");

    }

    public HttpStatus makeReservation(long seatId, User user) throws PassengerNotFoundException {

        Optional<Passenger> opt_passenger = passengerRepository.findById(seatId);
        if(opt_passenger.isPresent()){
            Passenger passenger = opt_passenger.get();
            passenger.setUser(user);
            passengerRepository.save(passenger);
            return HttpStatus.OK;
        }
        else throw new PassengerNotFoundException("passenger with id'"+ seatId+"' not found");
    }
}
