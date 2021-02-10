package com.kodilla.good.patterns.challenges;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
       /* MovieStore movieStore = new MovieStore();
        Map<String,List<String>> resultMap = movieStore.getMovies();
        resultMap.values().stream()
                .*/

        NewOrder newOrder = new NewOrder();
        OrderRequest orderRequest = newOrder.newOrder();
        ProductOrderService productOrderService = new ProductOrderService(new WarehousCheck(), new InfoService(), new WarehouseService());
        OrderDto orderDto = productOrderService.process(orderRequest);
        System.out.println("Uzytkownik: " + orderDto.getUser() + " Pomyslnie stworzyl zamowienie?: " + orderDto.isAvailable());
    }
}
