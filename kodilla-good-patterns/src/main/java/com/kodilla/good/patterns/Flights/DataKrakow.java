package com.kodilla.good.patterns.Flights;

import java.util.*;
import java.util.stream.Collectors;

public class DataKrakow implements GetInfo{
    private final static String TO = "Do";
    private final static String FROM = "Z";
    private HashMap<String, List<String>> data;
    private List<String>  toKraków;
    private List<String>  fromKraków;

    public DataKrakow() {
        data = new HashMap<>();
        toKraków = new ArrayList<>();
        toKraków.add("Warszawa");
        toKraków.add("Gdańsk");
        toKraków.add("Wrocław");
        fromKraków = new ArrayList<>();
        fromKraków.add("Warszawa");
        fromKraków.add("Gdańsk");
        fromKraków.add("Wrocław");
        data.put(TO, toKraków);
        data.put(FROM, fromKraków);
    }

    @Override
    public String getCities(String inOut) {
        boolean check;
        String cities;
        if (check = data.containsKey(inOut)){
            cities = data.get(inOut).stream()
                    .collect(Collectors.joining(","));
            return cities;
        }else {
            return "Błąd bazy danych";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataKrakow that = (DataKrakow) o;
        return Objects.equals(toKraków, that.toKraków) && Objects.equals(fromKraków, that.fromKraków);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toKraków, fromKraków);
    }
}
