package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAvarage(){
        double output = 0;
        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            output += temperature.getValue();
        }
        return output/temperatures.getTemperatures().size();
    }

    public double calculateMedian(){
        double output = 0;
        double avarage = 0;
        List<Double> sortedList = new ArrayList<>();
        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            sortedList.add(temperature.getValue());
        }
        Collections.sort(sortedList);
        if(temperatures.getTemperatures().size() % 2 == 0){
            avarage = sortedList.get(sortedList.size()/2) + sortedList.get((sortedList.size()/2)-1);
            output = avarage/2.0;
        }
        else{
            output = sortedList.get(sortedList.size()/2);
        }
        return output;
    }
}