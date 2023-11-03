package com.example.FlightsbookingRESTAPI.repository;

import com.example.FlightsbookingRESTAPI.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flights, Long> {
    public Flights getFlightsById(Long id);
    List<Flights> getAllFlightsByArrival(String arrival);

}
