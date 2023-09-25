package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.model.User;
import com.example.FlightsbookingRESTAPI.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
