package com.example.FlightsbookingRESTAPI.services;

import com.example.FlightsbookingRESTAPI.exeptions.UserNotFoundException;
import com.example.FlightsbookingRESTAPI.model.User;
import com.example.FlightsbookingRESTAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public HttpStatus save(User user) {
        userRepository.save(user);
        return HttpStatus.CREATED;
    }
    public HttpStatus deleteUserById(Long id) throws UserNotFoundException {
        Optional<User> opt_user = userRepository.getUserById(id);
        if(opt_user.isPresent()){
            userRepository.delete(opt_user.get());
            return HttpStatus.OK;
        }
        else throw new UserNotFoundException(" user with id '"+ id+"'not found");
    }

    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> opt_user = userRepository.getUserById(id);
        if(opt_user.isPresent()){
            return opt_user.get();
        }
        else throw new UserNotFoundException(" user with id '"+ id+"'not found");

    }

    public User getUserByName(String userName) throws UserNotFoundException {
        Optional<User> opt_user = userRepository.getUserByName(userName);
        if(opt_user.isPresent()){
            return opt_user.get();
        }
        else throw new UserNotFoundException("user with name '"+ userName +"' not found");

    }
}
