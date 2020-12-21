package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class World {

    private final List<Continent> continents = new ArrayList<>();

    public Stream<Object> getPeopleQuantity(){
        World world = new World();
        return continents.stream()
                .flatMap(Continent -> Continent.getContinents().stream())
                .flatMap(Country -> Country.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public World(){
        continents.add(new Continent("Africa"));
        continents.add(new Continent("Asia"));
        continents.add(new Continent("Europa"));
        continents.add(new Continent("North America"));
    }
}
