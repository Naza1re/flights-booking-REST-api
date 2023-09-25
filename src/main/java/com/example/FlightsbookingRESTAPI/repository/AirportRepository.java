package com.example.FlightsbookingRESTAPI.repository;

import com.example.FlightsbookingRESTAPI.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    public List<Airport> findAirportByName(String name);

    @Query("SELECT a FROM Airport a WHERE a.city = :airportCity")
    public List<Airport> findAirportByCity(String airportCity);

    Airport findAllById(Long id);


}
