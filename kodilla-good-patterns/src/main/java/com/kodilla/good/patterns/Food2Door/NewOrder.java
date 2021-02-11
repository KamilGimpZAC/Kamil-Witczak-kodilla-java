package com.kodilla.good.patterns.Food2Door;

public class NewOrder implements OrderProcess{
    @Override
    public NewOrder process(FoodProducer foodProducer, Product product, SendInfo sendInfo) {
        //if (sendInfo.checkIfCreated();){
         //   System.out.println("Utworzono zamówienie dla sklepu: " + foodProducer.getNAME() + " dLa produktu o numerze: " + product.getId() + " w ilości: " + product.getAmount());
        //}
        return new NewOrder();
    }
}
