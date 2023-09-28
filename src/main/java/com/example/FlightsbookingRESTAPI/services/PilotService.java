package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.PilotNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Pilot;
import com.example.FlightsbookingRESTAPI.model.Reservation;
import com.example.FlightsbookingRESTAPI.repository.PilotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotService {
    private final PilotRepository pilotRepository;

    public PilotService(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    public Pilot save(Pilot pilot){
        return pilotRepository.save(pilot);
    }
    public void delete(Pilot pilot){
        pilotRepository.delete(pilot);
    }
    public List<Pilot> getAllPilots(String airport_name){



          return pilotRepository.findAll();
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


}
