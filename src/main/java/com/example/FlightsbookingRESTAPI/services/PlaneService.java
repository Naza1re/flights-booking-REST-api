package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.model.Plane;
import com.example.FlightsbookingRESTAPI.model.Reservation;
import com.example.FlightsbookingRESTAPI.repository.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public Plane save(Plane plane){
        return planeRepository.save(plane);
    }

    public List<Plane> getAllReservations(){
        return planeRepository.findAll();
    }
    public Plane getPlaneById(Long id){
        return planeRepository.getReferenceById(id);
    }
}
