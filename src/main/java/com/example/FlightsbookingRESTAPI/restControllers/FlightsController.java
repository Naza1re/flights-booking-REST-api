    package com.example.FlightsbookingRESTAPI.restControllers;

    import com.example.FlightsbookingRESTAPI.exeptions.AirportNotFoundException;
    import com.example.FlightsbookingRESTAPI.exeptions.FlightCreationException;
    import com.example.FlightsbookingRESTAPI.model.Flights;
    import com.example.FlightsbookingRESTAPI.services.FlightsService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/flights")
    public class FlightsController {
       @Autowired
       private final FlightsService flightsService;

        public FlightsController(FlightsService flightsService) {
            this.flightsService = flightsService;
        }

        @PostMapping("/add-flight")
        public Flights addAirport(@RequestBody Flights flights){
            return flightsService.save(flights);
        }

        @GetMapping("/get-all")
        public List<Flights> getAllAirports(){
            return flightsService.findAll();
        }
    }
