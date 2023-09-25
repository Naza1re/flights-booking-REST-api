package com.example.FlightsbookingRESTAPI.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlightsDTO {
    String name;
    String departure_date;
    String departure_time;
    String arrival;

}
