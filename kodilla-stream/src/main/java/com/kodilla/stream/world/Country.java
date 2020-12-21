package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Country {

    private final String countryName;
    private final List<Country> countries = new ArrayList<>();

    public BigDecimal getPeopleQuantity(){
        if(Objects.equals(countryName, "Alegieria")){
            BigDecimal numberOfPeople = new BigDecimal(34994937);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "Gwinea")){
            BigDecimal numberOfPeople = new BigDecimal(10601009	);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "Egipt")){
            BigDecimal numberOfPeople = new BigDecimal(82079636);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "China")){
            BigDecimal numberOfPeople = new BigDecimal(1420000000);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "Japan")){
            BigDecimal numberOfPeople = new BigDecimal(125396901);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "South Kore")){
            BigDecimal numberOfPeople = new BigDecimal(51454000);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "United States of America")){
            BigDecimal numberOfPeople = new BigDecimal(326079000);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "Canada")){
            BigDecimal numberOfPeople = new BigDecimal(36708083);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "Mexico")){
            BigDecimal numberOfPeople = new BigDecimal(124574795);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "Poland")){
            BigDecimal numberOfPeople = new BigDecimal(38386000);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "Germany")){
            BigDecimal numberOfPeople = new BigDecimal(83019200);
            return numberOfPeople;
        }
        if(Objects.equals(countryName, "France")){
            BigDecimal numberOfPeople = new BigDecimal(67022000);
            return numberOfPeople;
        }
        else{
            return BigDecimal.ZERO;
        }
    }

    public Country(String countryName){
        this.countryName = countryName;
        countries.add(new Country("Alegieria"));
        countries.add(new Country("Gwinea"));
        countries.add(new Country("Egipt"));
        countries.add(new Country("China"));
        countries.add(new Country("Japan"));
        countries.add(new Country("South Kore"));
        countries.add(new Country("United States of America"));
        countries.add(new Country("Canada"));
        countries.add(new Country("Mexico"));
        countries.add(new Country("Poland"));
        countries.add(new Country("Germany"));
        countries.add(new Country("France"));
    }

    public List<Country> getCountries(){
        return countries;
    }
}
