package com.kodilla.sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SudokuElement {
    private int value;
    public static int EMPTY = -1;
    private List<Integer> possibleValues = new ArrayList<>();
    private int section;
    private int row;
    private int column;

    public SudokuElement(int section, int row, int column) {
        this.value = EMPTY;
        for (int i=1; i<10; i++) {
            this.possibleValues.add(i);
        }
        this.section = section;
        this.row = row;
        this.column = column;
    }

    public void removePossibleValue(int value) {
        for (int i=0; i<possibleValues.size(); i++) {
            if (possibleValues.get(i).equals(value)) {
                possibleValues.remove(i);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public int getSection() {
        return section;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        if (value != EMPTY) {
            return  " " + value + "  ";
        } else {
            return "   ";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuElement that = (SudokuElement) o;
        return value == that.value && section == that.section && row == that.row && column == that.column && Objects.equals(possibleValues, that.possibleValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, possibleValues, section, row, column);
    }
}
