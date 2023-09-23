package com.example.FlightsbookingRESTAPI.repository;

import com.example.FlightsbookingRESTAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
