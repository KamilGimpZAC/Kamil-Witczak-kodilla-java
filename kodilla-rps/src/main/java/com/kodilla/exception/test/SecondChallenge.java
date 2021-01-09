package com.kodilla.exception.test;

public class SecondChallenge {
    public static String probablyIWillThrowException(double x, double y) throws ExceptionHandling {
        if (x >= 2 || x < 1 || y == 1.5) {
            throw new ExceptionHandling();
        }
        return "Done!";
    }
}
