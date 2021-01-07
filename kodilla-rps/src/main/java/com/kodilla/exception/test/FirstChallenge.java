package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        double output = 0;
        try {
            output =  a/b;
        } catch (ArithmeticException e){
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Never divide by zero");
        }
        return output;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);

    }
}