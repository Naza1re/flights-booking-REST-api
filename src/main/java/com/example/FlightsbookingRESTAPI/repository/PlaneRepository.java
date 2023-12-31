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
    Plane getPlaneById(Long id);

    //work incorrect
    List<Plane> getAllByAirport_Name(String airport_name);
}
