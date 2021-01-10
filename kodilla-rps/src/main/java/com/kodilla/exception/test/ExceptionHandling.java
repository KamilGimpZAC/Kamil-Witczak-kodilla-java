package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

public class ExceptionHandling extends Exception{

    public static void main(String[] args) {
        double x = 3;
        double y = 1;
        try{
            SecondChallenge.probablyIWillThrowException(x,y);
        }
        catch (Exception e){
            System.out.println("Here is exception");
        }
        finally {
            System.out.println("It's working");
        }
    }
}
