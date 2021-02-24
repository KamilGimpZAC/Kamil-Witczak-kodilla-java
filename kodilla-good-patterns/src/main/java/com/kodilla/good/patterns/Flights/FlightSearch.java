package com.kodilla.good.patterns.Flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
    private final FlightsDatabase flightsDatabase = new FlightsDatabase();
    private List<Flight> airports = new ArrayList<>();

    public List<Flight> searchDeparture(String departureAirport) {
        airports = flightsDatabase.getConnections().stream()
                .filter(n -> n.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toList());
        return airports;
    }

    public List<Flight> searchArrival(String arrivalAirport) {
        airports = flightsDatabase.getConnections().stream()
                .filter(n -> n.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
        return airports;
    }

    public List<Flight> searchWithChange(String departureAirport, String changeAirport, String arrivalAirport) {
        airports = flightsDatabase.getConnections().stream()
                .filter(n -> n.getDepartureAirport().equals(departureAirport))
                .filter(n -> n.getArrivalAirport().equals(changeAirport))
                .collect(Collectors.toList());
        List<Flight> airports2 = flightsDatabase.getConnections().stream()
                .filter(n -> n.getDepartureAirport().equals(changeAirport))
                .filter(n -> n.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
        airports.addAll(airports2);
        return airports;
    }
}
