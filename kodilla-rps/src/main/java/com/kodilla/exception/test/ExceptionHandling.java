package com.kodilla.exception.test;

public class ExceptionHandling extends Exception{

    public void exceptionHandling() throws Exception {
        try{
        }
        catch (Exception e){
            System.out.println("Here is exception");
        }
        finally {
            System.out.println("It's working");
        }
    }

}
