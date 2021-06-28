package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuGame {
    private List<Backtrack> backtrackList = new ArrayList<>();
    private SudokuGenerator elementsGenerator = new SudokuGenerator();
    private SudokuController controller = new SudokuController();
    private SudokuBoard board = elementsGenerator.boardGenerator();
    private SudokuBoard boardDeepCopy = new SudokuBoard();


    public void StartGame() throws Exception {
        String start;
        String stop = null;
        boolean isSolved = false;
        Scanner scanner = new Scanner(System.in);

        board.drawBoard();
       /* do {
        do {
            System.out.println("W ktorym rzedzie chcesz dodac wartosc?");
            int row = scanner.nextInt() - 1;
            System.out.println("W ktorej kolumnie chcesz dodac wartosc?");
            int column = scanner.nextInt() - 1;
            System.out.println("Podaj wartosc do wprowadzenia (1-9)");
            int value = scanner.nextInt();
            board.getBoard().get(row).getRow().get(column).setValue(value);
            board.drawBoard();

            System.out.println("Aby zakonczyc dodawanie wartosci wpisz SUDOKU");
            scanner.nextLine();
            start = scanner.nextLine();
       } while (!start.equals("SUDOKU"));*/

        exampleSudokuWithoutGuessingTwo(board);
        board.drawBoard();
        System.out.println();
        controller.removingPossibleValuesFromValues(board);

        do {
            controller.removingValuesFromPossibleValuesRows(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInRow(board, backtrackList);
            controller.removingPossibleValuesFromValues(board);
            checkBacktrackNeed();
            controller.removingValuesFromPossibleValuesColumns(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInColumn(board, backtrackList);
            controller.removingPossibleValuesFromValues(board);
            checkBacktrackNeed();
            controller.removingValuesFromPossibleValuesSection(board);
            controller.lastPossibleNumberInElement(board);
            controller.lastPossibleInSection(board, backtrackList);
            controller.removingPossibleValuesFromValues(board);
            checkBacktrackNeed();

            System.out.println();
            System.out.println();
            board.drawBoard();

            if (controller.areAllElementsFilled(board) && !controller.isSudokuSolvedWell(board)) {
                controller.needToDoBacktrack = true;
                checkBacktrackNeed();
            }
            if (board.equals(boardDeepCopy)) {
                guessingOperation();
            } else {
                boardDeepCopy = board.boardDeepCopy();
            }
        } while (!controller.areAllElementsFilled(board) || !controller.isSudokuSolvedWell(board));

        board.cleanBoard();
        board = elementsGenerator.boardGenerator();

         //   promptEnterKey();

   //     } while(true);
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void guessingOperation() throws CloneNotSupportedException {
        backtrackList.add(controller.guessingOperation(board));
        System.out.println("Zgadywanie liczby i wykonanie kopii");

        Backtrack lastBacktrack = backtrackList.get(backtrackList.size()-1);
        board.getBoard().get(lastBacktrack.getRow()).getRow().get(lastBacktrack.getColumn()).setValue(lastBacktrack.getValue());
        board.getBoard().get(lastBacktrack.getRow()).getRow().get(lastBacktrack.getColumn()).removePossibleValue(lastBacktrack.getValue());
        board.drawBoard();
    }

    private void checkBacktrackNeed() {
        if (controller.needToDoBacktrack) {

            controller.needToDoBacktrack = false;
            board = backtrackList.get(backtrackList.size() - 1).getBoardDeepCopy();
            Backtrack lastBacktrack = backtrackList.get(backtrackList.size()-1);

            restartPossibleNumbers();
            controller.removingValuesFromPossibleValuesRows(board);
            controller.removingValuesFromPossibleValuesColumns(board);
            controller.removingValuesFromPossibleValuesSection(board);
            controller.removingPossibleValuesFromValues(board);
            board.getBoard().get(lastBacktrack.getRow()).getRow().get(lastBacktrack.getColumn()).removePossibleValue(lastBacktrack.getValue());
            for (Backtrack b : backtrackList ) {
                board.getBoard().get(b.getRow()).getRow().get(b.getColumn()).removePossibleValue(b.getValue());
            }

            System.out.println("Wykonano backtrack");
            board.drawBoard();
        }
    }

    private void restartPossibleNumbers() {
        board.getBoard().stream()
                .flatMap(n -> n.getRow().stream())
                .filter(n -> n.getValue() == -1)
                .forEach(n -> n.getPossibleValues().clear());

        List<Integer> allPossibleNumbers = new ArrayList<>();
        for (int i=1; i<10; i++) {
            allPossibleNumbers.add(i);
        }
        board.getBoard().stream()
                .flatMap(n -> n.getRow().stream())
                .filter(n -> n.getValue() == -1)
                .forEach(n -> n.getPossibleValues().addAll(allPossibleNumbers));
    }

    public void exampleSudokuWithoutGuessingOne(SudokuBoard board) {
        board.getBoard().get(0).getRow().get(0).setValue(9);
        board.getBoard().get(0).getRow().get(1).setValue(3);
        board.getBoard().get(0).getRow().get(3).setValue(1);
        board.getBoard().get(0).getRow().get(4).setValue(2);
        board.getBoard().get(0).getRow().get(5).setValue(6);
        board.getBoard().get(0).getRow().get(7).setValue(8);
        board.getBoard().get(0).getRow().get(8).setValue(7);

        board.getBoard().get(1).getRow().get(0).setValue(2);
        board.getBoard().get(1).getRow().get(1).setValue(1);
        board.getBoard().get(1).getRow().get(3).setValue(3);
        board.getBoard().get(1).getRow().get(5).setValue(7);
        board.getBoard().get(1).getRow().get(7).setValue(4);
        board.getBoard().get(1).getRow().get(8).setValue(6);

        board.getBoard().get(2).getRow().get(3).setValue(4);
        board.getBoard().get(2).getRow().get(5).setValue(9);

        board.getBoard().get(3).getRow().get(0).setValue(7);
        board.getBoard().get(3).getRow().get(1).setValue(2);
        board.getBoard().get(3).getRow().get(2).setValue(6);
        board.getBoard().get(3).getRow().get(6).setValue(8);
        board.getBoard().get(3).getRow().get(7).setValue(3);
        board.getBoard().get(3).getRow().get(8).setValue(4);

        board.getBoard().get(4).getRow().get(0).setValue(5);
        board.getBoard().get(4).getRow().get(8).setValue(9);

        board.getBoard().get(5).getRow().get(0).setValue(3);
        board.getBoard().get(5).getRow().get(1).setValue(4);
        board.getBoard().get(5).getRow().get(2).setValue(9);
        board.getBoard().get(5).getRow().get(6).setValue(1);
        board.getBoard().get(5).getRow().get(7).setValue(6);
        board.getBoard().get(5).getRow().get(8).setValue(5);

        board.getBoard().get(6).getRow().get(3).setValue(7);
        board.getBoard().get(6).getRow().get(5).setValue(1);

        board.getBoard().get(7).getRow().get(0).setValue(1);
        board.getBoard().get(7).getRow().get(1).setValue(7);
        board.getBoard().get(7).getRow().get(3).setValue(5);
        board.getBoard().get(7).getRow().get(5).setValue(3);
        board.getBoard().get(7).getRow().get(7).setValue(9);
        board.getBoard().get(7).getRow().get(8).setValue(2);

        board.getBoard().get(8).getRow().get(0).setValue(4);
        board.getBoard().get(8).getRow().get(1).setValue(5);
        board.getBoard().get(8).getRow().get(3).setValue(8);
        board.getBoard().get(8).getRow().get(4).setValue(9);
        board.getBoard().get(8).getRow().get(5).setValue(2);
        board.getBoard().get(8).getRow().get(7).setValue(7);
        board.getBoard().get(8).getRow().get(8).setValue(1);
    }

    public void exampleSudokuWithoutGuessingTwo(SudokuBoard board) {
        board.getBoard().get(0).getRow().get(0).setValue(4);
        board.getBoard().get(0).getRow().get(2).setValue(7);
        board.getBoard().get(0).getRow().get(3).setValue(3);
        board.getBoard().get(0).getRow().get(5).setValue(2);
        board.getBoard().get(0).getRow().get(6).setValue(9);
        board.getBoard().get(0).getRow().get(8).setValue(6);

        board.getBoard().get(1).getRow().get(1).setValue(1);
        board.getBoard().get(1).getRow().get(3).setValue(8);
        board.getBoard().get(1).getRow().get(5).setValue(7);
        board.getBoard().get(1).getRow().get(7).setValue(4);

        board.getBoard().get(2).getRow().get(0).setValue(5);
        board.getBoard().get(2).getRow().get(1).setValue(9);
        board.getBoard().get(2).getRow().get(2).setValue(3);
        board.getBoard().get(2).getRow().get(3).setValue(6);
        board.getBoard().get(2).getRow().get(5).setValue(1);
        board.getBoard().get(2).getRow().get(6).setValue(2);
        board.getBoard().get(2).getRow().get(7).setValue(8);
        board.getBoard().get(2).getRow().get(8).setValue(7);

        board.getBoard().get(3).getRow().get(0).setValue(2);
        board.getBoard().get(3).getRow().get(1).setValue(6);
        board.getBoard().get(3).getRow().get(2).setValue(1);
        board.getBoard().get(3).getRow().get(3).setValue(9);
        board.getBoard().get(3).getRow().get(5).setValue(8);
        board.getBoard().get(3).getRow().get(6).setValue(4);
        board.getBoard().get(3).getRow().get(7).setValue(7);
        board.getBoard().get(3).getRow().get(8).setValue(5);

        board.getBoard().get(4).getRow().get(1).setValue(4);
        board.getBoard().get(4).getRow().get(3).setValue(5);
        board.getBoard().get(4).getRow().get(5).setValue(6);
        board.getBoard().get(4).getRow().get(7).setValue(2);

        board.getBoard().get(5).getRow().get(0).setValue(3);
        board.getBoard().get(5).getRow().get(1).setValue(5);
        board.getBoard().get(5).getRow().get(2).setValue(9);
        board.getBoard().get(5).getRow().get(3).setValue(2);
        board.getBoard().get(5).getRow().get(5).setValue(4);
        board.getBoard().get(5).getRow().get(6).setValue(8);
        board.getBoard().get(5).getRow().get(7).setValue(6);
        board.getBoard().get(5).getRow().get(8).setValue(1);

        board.getBoard().get(6).getRow().get(0).setValue(1);
        board.getBoard().get(6).getRow().get(1).setValue(3);
        board.getBoard().get(6).getRow().get(2).setValue(4);
        board.getBoard().get(6).getRow().get(3).setValue(7);
        board.getBoard().get(6).getRow().get(5).setValue(5);
        board.getBoard().get(6).getRow().get(6).setValue(6);
        board.getBoard().get(6).getRow().get(7).setValue(9);
        board.getBoard().get(6).getRow().get(8).setValue(8);

        board.getBoard().get(7).getRow().get(1).setValue(7);
        board.getBoard().get(7).getRow().get(3).setValue(4);
        board.getBoard().get(7).getRow().get(5).setValue(3);
        board.getBoard().get(7).getRow().get(7).setValue(5);

        board.getBoard().get(8).getRow().get(0).setValue(8);
        board.getBoard().get(8).getRow().get(2).setValue(5);
        board.getBoard().get(8).getRow().get(3).setValue(1);
        board.getBoard().get(8).getRow().get(5).setValue(9);
        board.getBoard().get(8).getRow().get(6).setValue(7);
        board.getBoard().get(8).getRow().get(8).setValue(4);

    }

    public void exampleSudokuWithoutGuessingThree(SudokuBoard board) {
        board.getBoard().get(0).getRow().get(0).setValue(9);
        board.getBoard().get(0).getRow().get(2).setValue(6);
        board.getBoard().get(0).getRow().get(4).setValue(7);
        board.getBoard().get(0).getRow().get(6).setValue(4);
        board.getBoard().get(0).getRow().get(8).setValue(3);

        board.getBoard().get(1).getRow().get(3).setValue(4);
        board.getBoard().get(1).getRow().get(6).setValue(2);

        board.getBoard().get(2).getRow().get(1).setValue(7);
        board.getBoard().get(2).getRow().get(4).setValue(2);
        board.getBoard().get(2).getRow().get(5).setValue(3);
        board.getBoard().get(2).getRow().get(7).setValue(1);

        board.getBoard().get(3).getRow().get(0).setValue(5);
        board.getBoard().get(3).getRow().get(6).setValue(1);

        board.getBoard().get(4).getRow().get(1).setValue(4);
        board.getBoard().get(4).getRow().get(3).setValue(2);
        board.getBoard().get(4).getRow().get(5).setValue(8);
        board.getBoard().get(4).getRow().get(7).setValue(6);

        board.getBoard().get(5).getRow().get(2).setValue(3);
        board.getBoard().get(5).getRow().get(8).setValue(5);

        board.getBoard().get(6).getRow().get(1).setValue(3);
        board.getBoard().get(6).getRow().get(3).setValue(7);
        board.getBoard().get(6).getRow().get(7).setValue(5);

        board.getBoard().get(7).getRow().get(2).setValue(7);
        board.getBoard().get(7).getRow().get(5).setValue(5);

        board.getBoard().get(8).getRow().get(0).setValue(4);
        board.getBoard().get(8).getRow().get(2).setValue(5);
        board.getBoard().get(8).getRow().get(4).setValue(1);
        board.getBoard().get(8).getRow().get(6).setValue(7);
        board.getBoard().get(8).getRow().get(8).setValue(8);

    }

    public void exampleSudokuWithoutGuessingFour(SudokuBoard board) {
        board.getBoard().get(0).getRow().get(1).setValue(2);
        board.getBoard().get(0).getRow().get(2).setValue(8);
        board.getBoard().get(0).getRow().get(3).setValue(3);
        board.getBoard().get(0).getRow().get(5).setValue(5);
        board.getBoard().get(0).getRow().get(6).setValue(9);
        board.getBoard().get(0).getRow().get(7).setValue(7);

        board.getBoard().get(1).getRow().get(1).setValue(7);
        board.getBoard().get(1).getRow().get(2).setValue(9);
        board.getBoard().get(1).getRow().get(4).setValue(6);
        board.getBoard().get(1).getRow().get(6).setValue(1);
        board.getBoard().get(1).getRow().get(7).setValue(5);

        board.getBoard().get(2).getRow().get(1).setValue(6);
        board.getBoard().get(2).getRow().get(2).setValue(1);
        board.getBoard().get(2).getRow().get(6).setValue(3);
        board.getBoard().get(2).getRow().get(7).setValue(4);

        board.getBoard().get(3).getRow().get(2).setValue(5);
        board.getBoard().get(3).getRow().get(6).setValue(4);

        board.getBoard().get(4).getRow().get(1).setValue(3);
        board.getBoard().get(4).getRow().get(2).setValue(7);
        board.getBoard().get(4).getRow().get(3).setValue(8);
        board.getBoard().get(4).getRow().get(5).setValue(4);
        board.getBoard().get(4).getRow().get(6).setValue(6);
        board.getBoard().get(4).getRow().get(7).setValue(9);

        board.getBoard().get(5).getRow().get(2).setValue(6);
        board.getBoard().get(5).getRow().get(6).setValue(2);

        board.getBoard().get(6).getRow().get(3).setValue(7);
        board.getBoard().get(6).getRow().get(4).setValue(9);
        board.getBoard().get(6).getRow().get(5).setValue(6);

        board.getBoard().get(8).getRow().get(3).setValue(1);
        board.getBoard().get(8).getRow().get(5).setValue(2);


    }

    public void exampleSudokuWithoutGuessingFive(SudokuBoard board) {
        board.getBoard().get(0).getRow().get(1).setValue(2);
        board.getBoard().get(0).getRow().get(3).setValue(5);
        board.getBoard().get(0).getRow().get(5).setValue(1);
        board.getBoard().get(0).getRow().get(7).setValue(9);

        board.getBoard().get(1).getRow().get(0).setValue(8);
        board.getBoard().get(1).getRow().get(3).setValue(2);
        board.getBoard().get(1).getRow().get(5).setValue(3);
        board.getBoard().get(1).getRow().get(8).setValue(6);

        board.getBoard().get(2).getRow().get(1).setValue(3);
        board.getBoard().get(2).getRow().get(4).setValue(6);
        board.getBoard().get(2).getRow().get(7).setValue(7);

        board.getBoard().get(3).getRow().get(2).setValue(1);
        board.getBoard().get(3).getRow().get(6).setValue(6);

        board.getBoard().get(4).getRow().get(0).setValue(5);
        board.getBoard().get(4).getRow().get(1).setValue(4);
        board.getBoard().get(4).getRow().get(7).setValue(1);
        board.getBoard().get(4).getRow().get(8).setValue(9);

        board.getBoard().get(5).getRow().get(2).setValue(2);
        board.getBoard().get(5).getRow().get(6).setValue(7);

        board.getBoard().get(6).getRow().get(1).setValue(9);
        board.getBoard().get(6).getRow().get(4).setValue(3);
        board.getBoard().get(6).getRow().get(7).setValue(8);

        board.getBoard().get(7).getRow().get(0).setValue(2);
        board.getBoard().get(7).getRow().get(3).setValue(8);
        board.getBoard().get(7).getRow().get(5).setValue(4);
        board.getBoard().get(7).getRow().get(8).setValue(7);

        board.getBoard().get(8).getRow().get(1).setValue(1);
        board.getBoard().get(8).getRow().get(3).setValue(9);
        board.getBoard().get(8).getRow().get(5).setValue(7);
        board.getBoard().get(8).getRow().get(7).setValue(6);
    }
}
