package com.kodilla.sudoku;

public class SudokuGenerator {
    
    public SudokuBoard boardGenerator() {
        SudokuBoard board = new SudokuBoard();
        for (int i = 0; i < 9; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            for (int j = 0; j < 9; j++) {
                int section = sectionCheck(i,j);
                SudokuElement sudokuElement = new SudokuElement(section, j, i);
                sudokuRow.addElement(sudokuElement);
            }
            board.addRow(sudokuRow);
        }
        return board;
    }

    private int sectionCheck(int i, int j) {
        int result;
        if(j < 3 && i < 3){
            result = 1;
        } else if (j >= 3 && j < 6 && i < 3) {
            result = 2;
        } else if (j >= 6 && j < 9 && i < 3) {
            result = 3;
        } else if (j < 3  && i < 6) {
            result = 4;
        } else if (j >= 3 && j < 6 && i < 6) {
            result = 5;
        } else if (j >= 6 && j < 9 && i < 6) {
            result = 6;
        } else if (j < 3 && i < 9) {
            result = 7;
        } else if (j >= 3 && j < 6 && i < 9) {
            result = 8;
        } else if (j >= 6 && j < 9 && i < 9) {
            result = 9;
        } else {
            result = 0;
        }
        return result;
    }
}
