package com.example.FlightsbookingRESTAPI.repository;

import com.example.FlightsbookingRESTAPI.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
