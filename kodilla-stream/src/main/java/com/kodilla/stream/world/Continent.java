package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Continent {
    private final String continentName;
    private final List<Country> countries;

    public Continent(final String continentName, List<Country> countries) {
        this.continentName = continentName;
        this.countries = countries;
        }

    public List<Country> getCountries(){
        return countries;
    }
}
