package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bigmac {
    private final String bum;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    private Bigmac(String bum, int burgers, String sauce, List<String> ingredients) {
        this.bum = bum;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getBum() {
        return bum;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bum='" + bum + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(bum, burgers, sauce, ingredients);
    }

    public static class BigmacBuilder {
        private String bum;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bum(String bum) {
            this.bum = bum;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bum, burgers, sauce, ingredients);
        }
    }
}
