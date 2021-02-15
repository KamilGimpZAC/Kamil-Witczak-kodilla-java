package com.kodilla.good.patterns.Flights;


public class Main {
    public static void main(String[] args){
        //DataKrakow dataKraków = new DataKrakow();
        //DataWarszawa dataWarszawa = new DataWarszawa();
        DataBydgoszcz dataBydgoszcz = new DataBydgoszcz();
        CheckFlight checkFlight = new CheckFlight();
        AirportService airportService = new AirportService();
        String output = airportService.process(dataBydgoszcz,checkFlight,"Do");
        System.out.println("Lista lotów do Bydgoszczy: " + output);
    }
}
