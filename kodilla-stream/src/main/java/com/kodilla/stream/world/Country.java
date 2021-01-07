package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Country {

    private final String countryName;
    private final BigDecimal peopleQuantity;

    public BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }

    public Country(String countryName, BigDecimal peopleQuantity){
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;

    }
}
