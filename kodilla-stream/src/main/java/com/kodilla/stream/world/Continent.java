package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Continent {
    private final String continentName;
    private final List<Country> countries = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
        if(Objects.equals(continentName, "Africa")) {
            countries.add(new Country("Algieria"));
            countries.add(new Country("Egipt"));
            countries.add(new Country("Gwinea"));
        }
        if(Objects.equals(continentName, "Asia")) {
            countries.add(new Country("China"));
            countries.add(new Country("Japan"));
            countries.add(new Country("South Korea"));
        }
        if(Objects.equals(continentName, "North America")) {
            countries.add(new Country("United States of America"));
            countries.add(new Country("Canada"));
            countries.add(new Country("Mexico"));
        }
        if(Objects.equals(continentName, "Europa")) {
            countries.add(new Country("Poland"));
            countries.add(new Country("Germany"));
            countries.add(new Country("France"));
        }
    }

    public List<Country> getContinents() {
        return countries;
    }
}
