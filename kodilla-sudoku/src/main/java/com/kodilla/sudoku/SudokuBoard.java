package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> board = new ArrayList<>();

    public void addRow (SudokuRow row) {
        this.board.add(row);
    }

    public void drawBoard () {
        for (int i = 1; i < 10; i++) {
            board.get(i-1).drawSudokuRows();
            if (i % 3 == 0 && i != 9) {
                System.out.println(" -  -  -  -   -  -  -  -   -  -  -  -");
            }
        }
    }

    public SudokuBoard boardDeepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow row : board) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement element : row.getRow()) {
                SudokuElement sudokuElement = new SudokuElement(element.getSection(), element.getRow(), element.getColumn());
                sudokuElement.setValue(element.getValue());
                sudokuElement.setPossibleValues(element.getPossibleValues());
                clonedRow.getRow().add(sudokuElement);
            }
            clonedBoard.getBoard().add(clonedRow);
        }
        return clonedBoard;
    }

    public void cleanBoard() {
        board.clear();
    }

    public List<SudokuRow> getBoard() {
        return board;
    }
}
