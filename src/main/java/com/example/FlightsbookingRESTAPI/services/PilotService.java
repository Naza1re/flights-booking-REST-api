package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Pilot;
import com.example.FlightsbookingRESTAPI.model.Reservation;
import com.example.FlightsbookingRESTAPI.repository.PilotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {
    private final PilotRepository pilotRepository;

    public PilotService(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    public Pilot save(Pilot pilot){
        return pilotRepository.save(pilot);
    }
    public List<Pilot> getAllReservations(){
        return pilotRepository.findAll();
    }
    public Pilot getPilotById(Long id){
        return pilotRepository.getReferenceById(id);
    }
}
