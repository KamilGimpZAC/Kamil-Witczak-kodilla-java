package com.kodilla.sudoku;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SudokuRow {
    private List<SudokuElement> row = new ArrayList<>();

    public void addElement (SudokuElement element) {
        this.row.add(element);
    }

    public void drawSudokuRows() {
        for (int i = 1; i < 10; i++) {
            if (i % 3 != 0) {
                System.out.print(row.get(i - 1));
            } else  if (i == 9) {
                System.out.println(row.get(i - 1));
            } else {
                System.out.print(row.get(i - 1) + "|");
            }
        }
    }

    public List<SudokuElement> getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuRow sudokuRow = (SudokuRow) o;
        return Objects.equals(row, sudokuRow.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row);
    }
}
