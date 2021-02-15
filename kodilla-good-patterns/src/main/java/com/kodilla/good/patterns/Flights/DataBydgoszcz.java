package com.kodilla.good.patterns.Flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataBydgoszcz implements GetInfo{
    private final static String TO = "Do";
    private final static String FROM = "Z";
    private HashMap<String, List<String>> data;
    private List<String> toBydgoszcz;
    private List<String> fromBydgoszcz;

    public DataBydgoszcz() {
        data = new HashMap<>();
        toBydgoszcz = new ArrayList<>();
        toBydgoszcz.add("Warszawa");
        toBydgoszcz.add("Gdynia");
        toBydgoszcz.add("Lódź");
        fromBydgoszcz = new ArrayList<>();
        fromBydgoszcz.add("Warszawa");
        fromBydgoszcz.add("Gdynia");
        fromBydgoszcz.add("Lódź");
        data.put(TO,toBydgoszcz);
        data.put(FROM,fromBydgoszcz);
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
        DataBydgoszcz that = (DataBydgoszcz) o;
        return Objects.equals(toBydgoszcz, that.toBydgoszcz) && Objects.equals(fromBydgoszcz, that.fromBydgoszcz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBydgoszcz, fromBydgoszcz);
    }
}
