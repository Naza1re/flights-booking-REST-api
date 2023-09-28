    package com.example.FlightsbookingRESTAPI.restControllers;

    import com.example.FlightsbookingRESTAPI.exeptions.PlaneNotFoundException;
    import com.example.FlightsbookingRESTAPI.exeptions.ResponseNotFoundException;

    import com.example.FlightsbookingRESTAPI.model.Flights;

    import com.example.FlightsbookingRESTAPI.services.FlightsService;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/{airport_name}/flights")
    public class FlightsController {

       private final FlightsService flightsService;

        public FlightsController(FlightsService flightsService) {
            this.flightsService = flightsService;
        }

        @PostMapping("/add-flight")
        public HttpStatus addFlight(@PathVariable("airport_name") String name, @RequestBody Flights flights) throws ResponseNotFoundException {
            return flightsService.addFlight(name,flights);
        }
        @DeleteMapping("/{id}/delete")
        public HttpStatus deleteFlight(@PathVariable("airport_name") String name, @PathVariable Long id) throws ResponseNotFoundException {
            return flightsService.deleteFlight(id);
        }
        @GetMapping("/{id}")
        public Flights getFlight(@PathVariable Long id){
            return flightsService.getFlightsById(id);
        }

        @GetMapping("/all-flights")
        public ResponseEntity<List<Flights>> getAllFlights(@PathVariable("airport_name") String name) {
            return flightsService.getAllFlightOfAirport(name);
        }

        @PostMapping("{id}/addPlane/{plane_id}")
        private HttpStatus addPlane(@PathVariable String airport_name, @PathVariable Long id,@PathVariable Long plane_id) throws PlaneNotFoundException {
            return flightsService.addPlaneToFlight(id,plane_id);

        }
        //almost done

    }
