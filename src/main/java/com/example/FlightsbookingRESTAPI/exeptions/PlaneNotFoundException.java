package com.example.FlightsbookingRESTAPI.exeptions;

public class PlaneNotFoundException extends Exception {
    public PlaneNotFoundException(String s) {
        super(s);
    }
}
