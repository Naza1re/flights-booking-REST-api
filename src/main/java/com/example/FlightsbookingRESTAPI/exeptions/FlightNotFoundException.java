package com.example.FlightsbookingRESTAPI.exeptions;

public class FlightNotFoundException extends Throwable {
    public FlightNotFoundException(String s) {
        super(s);
    }
}
