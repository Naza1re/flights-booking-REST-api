    package com.example.FlightsbookingRESTAPI.restControllers;

    import com.example.FlightsbookingRESTAPI.model.Airport;
    import com.example.FlightsbookingRESTAPI.model.Flights;
    import com.example.FlightsbookingRESTAPI.services.AirportService;
    import com.example.FlightsbookingRESTAPI.services.FlightsService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/{airport_name}/flights")
    public class FlightsController {
       @Autowired
       private final FlightsService flightsService;
       private final AirportService airportService;

        public FlightsController(FlightsService flightsService, AirportService airportService) {
            this.flightsService = flightsService;
            this.airportService = airportService;

        }

        @PostMapping("/add-flight")
        public Flights addFlight(@PathVariable("airport_name") String name,  @RequestBody Flights flights){
            return flightsService.save(flights);
        }

        @GetMapping("/allFlights")
        public ResponseEntity<List<Flights>> getAllFlights(@PathVariable("airport_name") String name) {
            return flightsService.getAllFlightOfAirport(name);

        }


        @PostMapping("/{id}/addFlight")
        public Flights addFlight(@RequestBody Flights flights, @PathVariable Long id){
            Airport airport = airportService.findAirportById(id);
            flights.setAirport(airport);
            return flightsService.save(flights);
        }
    }
