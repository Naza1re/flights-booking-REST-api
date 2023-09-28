package com.example.FlightsbookingRESTAPI.exeptions;

public class PilotNotFoundException extends Throwable {
    public PilotNotFoundException(String s){
        super(s);
    }
}
