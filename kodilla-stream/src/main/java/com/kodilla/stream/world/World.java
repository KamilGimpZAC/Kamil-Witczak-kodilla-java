package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

    private final List<Continent> continents = new ArrayList<>();

    public BigDecimal getPeopleQuantity(){
        World world = new World();
        return continents.stream()
                .flatMap(Continent -> Continent.getContinents().stream())
                .map(c -> c.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public World(){
        continents.add(new Continent("Africa"));
        continents.add(new Continent("Asia"));
        continents.add(new Continent("Europa"));
        continents.add(new Continent("North America"));
    }
}
