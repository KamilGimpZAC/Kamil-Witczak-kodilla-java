package com.kodilla.testing.collection;

import java.util.List;

public class OddNumbersExterminator {

    public Object exterminate(List<Integer> numbers) {
        //List<Integer> listEven = null;
        if (numbers != null) {
            for (Integer storageNumber : numbers) {
                if (storageNumber % 2 != 0) {
                    numbers.remove(storageNumber);
                }
            }
            return numbers;
        } else {
            return "List is empty";
        }
    }
}
