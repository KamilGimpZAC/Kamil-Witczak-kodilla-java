package com.kodilla.exception.test;

public class ExceptionHandling extends Exception{

    public void exceptionHandling(double x, double y) throws Exception {
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
