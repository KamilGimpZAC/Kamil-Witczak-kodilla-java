package com.kodilla.good.patterns.Flights;

public class AirportService {
    public String process(GetInfo getInfo, IsAvailable isAvailable, String inOut){
        String output = getInfo.getCities(inOut);
        isAvailable.check();
        return output;
    }
}
