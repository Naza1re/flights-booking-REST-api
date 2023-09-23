package com.example.FlightsbookingRESTAPI.repository;

import com.example.FlightsbookingRESTAPI.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
