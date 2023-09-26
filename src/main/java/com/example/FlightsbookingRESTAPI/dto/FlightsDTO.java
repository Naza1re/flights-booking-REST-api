    package com.example.FlightsbookingRESTAPI.dto;

    import com.example.FlightsbookingRESTAPI.model.Airport;
    import com.example.FlightsbookingRESTAPI.model.Flights;
    import lombok.Getter;
    import lombok.Setter;
    import org.modelmapper.ModelMapper;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    @Getter
    @Setter
    public class FlightsDTO {
        String name;
        String departure_date;
        String departure_time;
        String arrival;


    }
