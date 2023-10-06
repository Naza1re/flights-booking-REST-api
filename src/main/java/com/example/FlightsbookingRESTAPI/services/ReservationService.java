package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.ReservationNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.UserNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Flights;
import com.example.FlightsbookingRESTAPI.model.Reservation;
import com.example.FlightsbookingRESTAPI.model.User;
import com.example.FlightsbookingRESTAPI.repository.FlightRepository;
import com.example.FlightsbookingRESTAPI.repository.ReservationRepository;
import com.example.FlightsbookingRESTAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository repository;
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(ReservationRepository repository, FlightRepository flightRepository, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.repository = repository;
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public HttpStatus saveReservation(Reservation reservation){
        repository.save(reservation);
        return HttpStatus.OK;
    }
    public List<Reservation> getAllReservations(){
        return repository.findAll();
    }
    public Reservation getReservationById(Long id){
        return repository.getReferenceById(id);
    }
    public void delete(Reservation reservation){
        reservationRepository.delete(reservation);
    }

    public HttpStatus makeReserve(Long id, Reservation reservation,String name) throws UserNotFoundException {
        Flights flights = flightRepository.getFlightsById(id);
        reservation.setFlights(flights);
        Optional<User> opt_user = userRepository.getUserByName(name);
        if(opt_user.isPresent()){
            reservation.setUser(opt_user.get());
            repository.save(reservation);
            return HttpStatus.CREATED;
        }
        else
            throw new UserNotFoundException("user with name '"+ name+"' not found");
    }

    public List<Reservation> getAllReservations(String airportName, Long id) {
        List<Reservation> allReservations = reservationRepository.findAll();
        List<Reservation> filteredReservation = new ArrayList<>();

        for(Reservation reservation : allReservations){
            if(reservation.getFlights().getAirport().getName().equals(airportName)&&reservation.getFlights().getId().equals(id)){
                filteredReservation.add(reservation);
            }
        }
        return filteredReservation;
    }

    public HttpStatus delete(Long id) throws ReservationNotFoundException {
        Optional<Reservation> opt_reservation = reservationRepository.getReservationById(id);
        if(opt_reservation.isPresent()){
            reservationRepository.delete(opt_reservation.get());
            return HttpStatus.OK;
        }
        else
            throw new ReservationNotFoundException("reservation with id '"+ id+ "' not found");
    }
}
