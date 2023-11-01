package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PilotNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Airport;
import com.example.FlightsbookingRESTAPI.model.Pilot;
import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.repository.AirportRepository;
import com.example.FlightsbookingRESTAPI.repository.PilotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class PilotService {
    private final PilotRepository pilotRepository;
    private final AirportRepository airportRepository;

    public PilotService(PilotRepository pilotRepository, AirportRepository airportRepository) {
        this.pilotRepository = pilotRepository;
        this.airportRepository = airportRepository;
    }

    public Pilot save(Pilot pilot){
        return pilotRepository.save(pilot);
    }
    public void delete(Pilot pilot){
        pilotRepository.delete(pilot);
    }
    public List<Pilot> getAllPilots(String airport_name) throws AirportNotFoundException {
        List<Pilot> allPilots =  pilotRepository.findAll();
        List<Pilot> filteredPilots = new ArrayList<>();

        Optional<Airport> opt_airport = airportRepository.findByName(airport_name);
        if(opt_airport.isPresent()){
            for(Pilot pilot : allPilots){
                if(pilot.getAirport().getName().equals(airport_name)){
                    filteredPilots.add(pilot);
                }
            }
            return filteredPilots.stream().sorted((p,p2)->p2.getAge()-p.getAge()).toList();
        }
        else throw new AirportNotFoundException("airport '" + airport_name + "' not found");

    }
    public Pilot getPilotById(Long id){
        return pilotRepository.getReferenceById(id);
    }

    public HttpStatus delete(Long id) throws PilotNotFoundException {
        Optional<Pilot> opt_pilot = pilotRepository.getPilotById(id);
        if(opt_pilot.isPresent()){
            delete(opt_pilot.get());
            return HttpStatus.OK;
        }
        else throw new PilotNotFoundException("pilot '"+opt_pilot+"' not fond");

    }


    public List<Pilot> getAllFreePilotsOfAirport(String airportName) throws AirportNotFoundException {
        Optional<Airport> opt_airport = airportRepository.findByName(airportName);
        if(opt_airport.isPresent()){
            return pilotRepository.getAllByAirport_Name(airportName);

        }
        else throw new AirportNotFoundException("airport with name '"+opt_airport+"' not found");

    }
}
