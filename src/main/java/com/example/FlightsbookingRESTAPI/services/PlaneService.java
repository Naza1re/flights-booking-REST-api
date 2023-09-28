package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.model.Passenger;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.repository.PassengerRepository;
import com.example.FlightsbookingRESTAPI.repository.PlaneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class PlaneService {

    private final PlaneRepository planeRepository;
    private final AirportRepository airportRepository;
    private final PassengerRepository passengerRepository;


    public PlaneService(PlaneRepository planeRepository, AirportRepository airportService1, PassengerRepository passengerRepository) {
        this.planeRepository = planeRepository;
        this.airportRepository = airportService1;
        this.passengerRepository = passengerRepository;
    }

    public Plane save(Plane plane){
        return planeRepository.save(plane);
    }
    public HttpStatus addPlane(String airportName,Plane plane,String type) throws ResponseNotFoundException, AirportNotFoundException, IncorrectResultSetColumnCountException {
        Optional<Airport> opt_airport = airportRepository.findByName(airportName);
        if(opt_airport.isPresent()){
            plane.setAirport(opt_airport.get());
            planeRepository.save(plane);
            if(type.equals("Airbus")){
                for(int i = 0;i<30;i++){
                    Passenger p = new Passenger();
                    p.setSeat(i);
                    p.setPlane(plane);
                    passengerRepository.save(p);
                }
            }
            else if(type.equals("Boeng")){
                for(int i = 0;i<20;i++){
                    Passenger p = new Passenger();
                    p.setSeat(i);
                    p.setPlane(plane);
                    passengerRepository.save(p);

                }
                return HttpStatus.OK;
            }else {
                return HttpStatus.OK;
            }
        }
        else throw new AirportNotFoundException("airport'" + airportName+"'not found");
        return HttpStatus.BAD_REQUEST;
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
}
