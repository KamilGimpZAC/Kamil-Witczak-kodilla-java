package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

public class World {

    private final List<Continent> continents;

    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(Continent -> Continent.getCountries().stream())
                .map(c -> c.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public World(List<Continent> continents){
        this.continents = continents;
    }
}
