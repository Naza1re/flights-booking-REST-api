package com.example.FlightsbookingRESTAPI.repository;

import com.example.FlightsbookingRESTAPI.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaneRepository extends JpaRepository<Plane,Long> {
    Optional<Plane> findByName(String name);
    public Plane getPlaneById(Long id);

    @Query("SELECT p FROM Plane p WHERE p.id NOT IN (SELECT f.plane.id FROM Flights f WHERE f.airport.id = :airportId)")
    List<Plane> findFreePlanesByAirportId(@Param("airportId") Long airportId);
}
