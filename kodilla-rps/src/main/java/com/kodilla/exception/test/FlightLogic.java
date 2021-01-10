package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Random;

public class FlightLogic {

    Random random = new Random();
    public void findFlight(Flight flight) throws RouteNotFoundException{
        HashMap<String,Boolean> availability = new HashMap<>();
        availability.put(flight.getArrivalAirport(), random.nextBoolean());
        if(availability.containsValue(true)){
            System.out.println("You can get to this airport");
        }
        else{
            throw new RouteNotFoundException();
        }
    }
}
