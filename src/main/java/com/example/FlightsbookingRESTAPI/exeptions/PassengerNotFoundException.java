package com.example.FlightsbookingRESTAPI.exeptions;

public class PassengerNotFoundException extends Throwable {
    public PassengerNotFoundException(String s) {
        super(s);
    }
}
