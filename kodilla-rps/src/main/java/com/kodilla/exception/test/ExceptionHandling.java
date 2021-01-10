package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

public class ExceptionHandling extends Exception{

    public static void main(String[] args) {
        try{
            SecondChallenge.probablyIWillThrowException(3,1);
        }
        catch (Exception e){
            System.out.println("Here is exception");
        }
        finally {
            System.out.println("It's working");
        }
    }
}
