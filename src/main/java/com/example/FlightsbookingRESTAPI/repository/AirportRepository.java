package com.example.FlightsbookingRESTAPI.repository;

import com.example.FlightsbookingRESTAPI.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    public List<Airport> findAirportByName(String name);
    Optional<Airport> findByName(String name);

    Airport findAllById(Long id);


}
