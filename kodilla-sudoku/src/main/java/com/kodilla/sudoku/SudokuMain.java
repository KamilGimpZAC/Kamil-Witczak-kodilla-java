package com.kodilla.sudoku;

public class SudokuMain {
    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        try {
            game.StartGame();
        } catch (Exception e) {
            System.out.println("Error reached: " + e);
        }
    }
}
