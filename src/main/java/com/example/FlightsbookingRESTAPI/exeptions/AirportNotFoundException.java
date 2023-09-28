package com.example.FlightsbookingRESTAPI.exeptions;

public class AirportNotFoundException extends Exception {
    public AirportNotFoundException(String s) {
        super(s);
    }
}
