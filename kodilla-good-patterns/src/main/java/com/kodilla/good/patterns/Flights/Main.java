package com.kodilla.good.patterns.Flights;

public class Main {
    public static void main(String[] args){
        FlightSearch flightSearch = new FlightSearch();
        System.out.println("Departure airport: WAW");
        flightSearch.searchDeparture("WAW").stream()
                .map(Flight::toString)
                .forEach(System.out::println);
        System.out.println("Arrival airport: KRK");
        flightSearch.searchArrival("KRK").stream()
                .map(Flight::toString)
                .forEach(System.out::println);
        System.out.println("From WRO to POZ, change in WAW");
        flightSearch.searchWithChange("WRO","WAW","POZ").stream()
                .map(Flight::toString)
                .forEach(System.out::println);
    }
}
