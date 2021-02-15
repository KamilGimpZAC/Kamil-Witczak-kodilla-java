package com.kodilla.good.patterns.Flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataWarszawa implements GetInfo{
    private final static String TO = "Do";
    private final static String FROM = "Z";
    private HashMap<String, List<String>> data;
    private List<String> toWarszawa;
    private List<String> fromWarszawa;

    public DataWarszawa() {
        data = new HashMap<>();
        toWarszawa = new ArrayList<>();
        toWarszawa.add("Gdańsk");
        toWarszawa.add("Szczecin");
        toWarszawa.add("Kraków");
        fromWarszawa = new ArrayList<>();
        fromWarszawa.add("Gdańsk");
        fromWarszawa.add("Szczecin");
        fromWarszawa.add("Kraków");
        data.put(TO,toWarszawa);
        data.put(FROM,fromWarszawa);
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
        DataWarszawa that = (DataWarszawa) o;
        return Objects.equals(toWarszawa, that.toWarszawa) && Objects.equals(fromWarszawa, that.fromWarszawa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toWarszawa, fromWarszawa);
    }
}
