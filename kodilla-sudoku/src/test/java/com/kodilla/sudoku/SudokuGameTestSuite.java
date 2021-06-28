package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SudokuGameTestSuite {

    @Test
    void elementsGeneratorTestSuite() {
        //Given
        SudokuGenerator elementsGenerator = new SudokuGenerator();

        //When
        SudokuBoard board = elementsGenerator.boardGenerator();
        int resultRows = board.getBoard().size();

        long resultElements = board.getBoard().stream()
                .flatMap(n->n.getRow().stream())
                .count();
        //Then
        assertEquals(9, resultRows);
        assertEquals(81, resultElements);
    }

    @Test
    void boardDrawerTestSuite() {
        //Given
        SudokuGenerator elementsGenerator = new SudokuGenerator();

        //When && Then
        SudokuBoard board = elementsGenerator.boardGenerator();
        board.drawBoard();

    }

    @Test
    void possibleValuesSudokuElementsTestSuite() {
        //Given
        SudokuGenerator elementsGenerator = new SudokuGenerator();

        //When
        SudokuBoard board = elementsGenerator.boardGenerator();
        List<Integer> possibleValues = board.getBoard().get(0).getRow().get(0).getPossibleValues();
        System.out.println(possibleValues);

        //Then
        assertEquals(9, possibleValues.size());
    }

    @Test
    void removingValuesFromPossibleValuesTestSuite() {
        //Given
        SudokuGenerator elementsGenerator = new SudokuGenerator();
        SudokuController sudokuController = new SudokuController();

        //When
        SudokuBoard board = elementsGenerator.boardGenerator();
        sudokuController.removingValuesFromPossibleValuesRows(board);
        List<Integer> possibleValues = board.getBoard().get(0).getRow().get(0).getPossibleValues();
        System.out.println(possibleValues);

        //Then
        assertEquals(9, possibleValues.size());
    }
}