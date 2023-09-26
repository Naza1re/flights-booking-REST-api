package com.example.FlightsbookingRESTAPI.dto;

import com.example.FlightsbookingRESTAPI.model.Airport;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
@Getter
@Setter
public class AirportDTO {
    String name;
    String city;
    String street;
    List<FlightsDTO> flightsDTOS;

    /*public static AirportDTO convertFlightToDTO(Airport airport){
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setCity(airport.getCity());
        airportDTO.setName(airport.getName());
        airportDTO.setStreet(airport.getStreet());
        List<FlightsDTO> flightsDTOList = new ArrayList<>();
        for (Flights flight : airport.getFlightsList()) {
            FlightsDTO flightDTO = new FlightsDTO();
            flightDTO.setName(flight.getName());
            flightDTO.setDeparture_date(flight.getDeparture_date());
            flightDTO.setDeparture_time(flight.getDeparture_time());
            flightDTO.setArrival(flight.getArrival());
            flightsDTOList.add(flightDTO);
        }
        airportDTO.setFlightsDTOS(flightsDTOList);
        return airportDTO;
    }

*/

    public AirportDTO() {

    }


    public static AirportDTO convertAirportToDTO(Airport airport, ModelMapper modelMapper) {
        AirportDTO airportDTO = modelMapper.map(airport, AirportDTO.class);
        return airportDTO;
    }

}
