package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;

import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;

import com.example.FlightsbookingRESTAPI.repository.PlaneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



@Service
public class PlaneService {

    private final PlaneRepository planeRepository;
    private final AirportRepository airportRepository;



    public PlaneService(PlaneRepository planeRepository, AirportRepository airportService1) {
        this.planeRepository = planeRepository;
        this.airportRepository = airportService1;
    }



    public List<Plane> getAllReservations(){
        return planeRepository.findAll();
    }
    public Plane getPlaneById(Long id){
        return planeRepository.getReferenceById(id);
    }

    public HttpStatus delete(String airportName, Long id) throws AirportNotFoundException {
        Optional<Airport> opt_airport = airportRepository.findByName(airportName);
        if(opt_airport.isPresent()){
            planeRepository.delete(planeRepository.getPlaneById(id));
            return HttpStatus.OK;
        }
        else throw new AirportNotFoundException("airport'" + airportName+"'not found");
    }

    public HttpStatus addPlane(String name, Plane plane) throws AirportNotFoundException {
        Optional<Airport> opt_airport = airportRepository.findByName(name);
        if(opt_airport.isPresent()){
            plane.setAirport(opt_airport.get());
            planeRepository.save(plane);
            return HttpStatus.CREATED;
        }
        else throw new AirportNotFoundException("airport '" + name + "' not found");

    }

    public List<Plane> getAllPlanes(String airport_name) throws AirportNotFoundException {
        List<Plane> allPlanes =  planeRepository.findAll();
        List<Plane> filteredPlanes = new ArrayList<>();

        Optional<Airport> opt_airport = airportRepository.findByName(airport_name);
        if(opt_airport.isPresent()){
            for(Plane plane : allPlanes){
                if(plane.getAirport().getName().equals(airport_name)){
                    filteredPlanes.add(plane);
                }
            }
            return filteredPlanes;
        }
        else throw new AirportNotFoundException("airport '" + airport_name + "' not found");

    }

    public List<Plane> getAllFreePlanes(String airportName) {
        Optional<Airport> opt_Airport = airportRepository.findByName(airportName);
        if (opt_Airport.isPresent()) {
            return planeRepository.getAllByAirport_Name(airportName);
        }
        else
            return null;
    }

}
