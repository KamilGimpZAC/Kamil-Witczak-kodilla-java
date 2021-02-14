package com.kodilla.good.patterns.Food2Door;

import java.util.Random;

public class NewProduct {
    public Product newProduct(){
        Random random = new Random();
        int id = random.nextInt(2000)+1000;
        int amount = random.nextInt(20)+1;
        return new Product(id,amount);
    }
}
