package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        Country country1 = new Country("Algieria", new BigDecimal(34994937));
        Country country2 = new Country("Gwinea", new BigDecimal(10601009));
        Country country3 = new Country("Egipt", new BigDecimal(82079636));
        Country country4 = new Country("China", new BigDecimal(1420000000));
        Country country5 = new Country("Japan", new BigDecimal(125396901));
        Country country6 = new Country("South Korea", new BigDecimal(51454000));
        Country country7 = new Country("USA", new BigDecimal(326079000));
        Country country8 = new Country("Canada", new BigDecimal(36708083));
        Country country9 = new Country("Mexico", new BigDecimal(124574795));
        Country country10 = new Country("Poland", new BigDecimal(8386000));
        Country country11 = new Country("Germany", new BigDecimal(83019200));
        Country country12 = new Country("France", new BigDecimal(67022000));

        List<Country> countries1 = new ArrayList<>(){{
            add(country1);
            add(country2);
            add(country3);
        }};

        List<Country> countries2 = new ArrayList<>(){{
            add(country4);
            add(country5);
            add(country6);
        }};

        List<Country> countries3 = new ArrayList<>(){{
            add(country7);
            add(country8);
            add(country9);
        }};

        List<Country> countries4 = new ArrayList<>(){{
            add(country10);
            add(country11);
            add(country12);
        }};

        Continent continent1 = new Continent("Africa", countries1);
        Continent continent2 = new Continent("Asia", countries2);
        Continent continent3 = new Continent("North America", countries3);
        Continent continent4 = new Continent("Europa", countries4);

        List<Continent> continents = new ArrayList<>(){{
            add(continent1);
            add(continent2);
            add(continent3);
            add(continent4);
        }};

        World world = new World(continents);
        //When
        BigDecimal totalPeople;
        totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPeople = new BigDecimal("2370315561");
        assertEquals(expectedPeople, totalPeople);
    }
}
