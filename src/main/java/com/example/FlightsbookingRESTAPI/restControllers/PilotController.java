package com.example.FlightsbookingRESTAPI.restControllers;

import com.example.FlightsbookingRESTAPI.model.Pilot;
import com.example.FlightsbookingRESTAPI.services.PilotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pilots")
public class PilotController {

    private final PilotService pilotService;

    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @PostMapping("/add-pilot")
    public Pilot addPilot(@RequestBody Pilot pilot){
       return  pilotService.save(pilot);
    }

}
