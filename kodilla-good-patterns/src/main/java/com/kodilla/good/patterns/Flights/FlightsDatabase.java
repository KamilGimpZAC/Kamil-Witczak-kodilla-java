package com.kodilla.good.patterns.Flights;

import java.util.ArrayList;
import java.util.List;

public class FlightsDatabase {
    private final List<Flight> connections;

    public FlightsDatabase() {
        this.connections = new ArrayList<>();

        connections.add(new Flight("WAW", "KRK"));
        connections.add(new Flight("WAW", "WRO"));
        connections.add(new Flight("WAW", "POZ"));
        connections.add(new Flight("WAW", "GDN"));

        connections.add(new Flight("KRK", "WAW"));
        connections.add(new Flight("KRK", "WRO"));
        connections.add(new Flight("KRK", "POZ"));
        connections.add(new Flight("KRK", "GDN"));

        connections.add(new Flight("WRO", "KRK"));
        connections.add(new Flight("WRO", "WAW"));
        connections.add(new Flight("WRO", "POZ"));
        connections.add(new Flight("WRO", "GDN"));

        connections.add(new Flight("GDN", "KRK"));
        connections.add(new Flight("GDN", "WRO"));
        connections.add(new Flight("GDN", "POZ"));
        connections.add(new Flight("GDN", "WAW"));
    }

    public List<Flight> getConnections() {
        return connections;
    }
}
