package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.exeptions.UserNotFoundException;
import com.example.FlightsbookingRESTAPI.model.User;
import com.example.FlightsbookingRESTAPI.repository.UserRepository;
import com.example.FlightsbookingRESTAPI.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    HttpStatus addUser(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/all-users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}/delete")
    public HttpStatus deleteUser(@PathVariable Long id) throws UserNotFoundException {
        return userService.deleteUserById(id);
    }
    @GetMapping("/getUserByName/{user_name}")
    public User getUserByName(@PathVariable String user_name) throws UserNotFoundException {
        return userService.getUserByName(user_name);
    }


}
