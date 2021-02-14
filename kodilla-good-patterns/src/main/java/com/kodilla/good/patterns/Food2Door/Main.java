package com.kodilla.good.patterns.Food2Door;


public class Main {
    public static void main(String[] args){
        Product product1 = new NewProduct().newProduct();
        Product product2 = new NewProduct().newProduct();
        Product product3 = new NewProduct().newProduct();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop(product1,new SendInfo());
        HealthyShop healthyShop = new HealthyShop(product2,new SendInfo());
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop(product3, new SendInfo());

        extraFoodShop.process();
        healthyShop.process();
        glutenFreeShop.process();
    }
}
