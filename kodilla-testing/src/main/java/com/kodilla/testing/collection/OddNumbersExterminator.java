package com.kodilla.testing.collection;

import java.util.LinkedList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> newList = new LinkedList<>();
        for (Integer storageNumber : numbers) {
            if (storageNumber % 2 == 0) {
                    newList.add(storageNumber);
                }
            }
            return newList;
    }
}
