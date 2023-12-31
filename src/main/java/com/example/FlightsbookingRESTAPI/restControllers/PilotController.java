package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
import com.example.FlightsbookingRESTAPI.exeptions.PilotNotFoundException;
import com.example.FlightsbookingRESTAPI.model.Pilot;
import com.example.FlightsbookingRESTAPI.services.PilotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{airport_name}/pilots")
public class PilotController {

    private final PilotService pilotService;

    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @PostMapping("/add-pilot")
    public HttpStatus addPilot(@RequestBody Pilot pilot, @PathVariable String airport_name) throws AirportNotFoundException {
       return  pilotService.save(pilot,airport_name);
    }
    @DeleteMapping( "{id}/delete")
    HttpStatus deletePilot(@PathVariable Long id, @PathVariable String airport_name) throws PilotNotFoundException {
        return pilotService.delete(id);
    }
    @GetMapping("/{id}")
    public Pilot getPilot(@PathVariable Long id, @PathVariable String airport_name){
        return pilotService.getPilotById(id);
    }
    @GetMapping("/all-pilots")
    List<Pilot> getAllPilots(@PathVariable String airport_name) throws AirportNotFoundException {
        return pilotService.getAllPilots(airport_name);
    }
    @GetMapping("/free")
    List<Pilot> getAllFreePilotsOfAirport(@PathVariable String airport_name) throws AirportNotFoundException {
        return pilotService.getAllFreePilotsOfAirport(airport_name);
    }




}
