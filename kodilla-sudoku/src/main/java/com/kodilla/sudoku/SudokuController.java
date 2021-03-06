package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class SudokuController {
    boolean needToDoBacktrack = false;
    private Set<Integer> allInRow = new LinkedHashSet<>();
    private List<SudokuElement> previouslyUsedElements = new ArrayList<>();

    public void removingValuesFromPossibleValuesRows(SudokuBoard board) {
        List<Integer> valuesInRow = new ArrayList<>();
        for (int row = 0; row < board.getBoard().size(); row++) {
            valuesInRow.clear();
            for (int column = 0; column < board.getBoard().get(row).getRow().size(); column++) {
                SudokuElement sudokuElement = board.getBoard().get(row).getRow().get(column);
                if (sudokuElement.getValue() != -1) {
                    valuesInRow.add(sudokuElement.getValue());
                }
            }
            board.getBoard().get(row).getRow().stream()
                    .map(n -> n.getPossibleValues())
                    .forEach(n -> n.removeAll(valuesInRow));
        }
    }

    public void lastPossibleInRow(SudokuBoard board, List<Backtrack> backtrackList) throws Exception {
        Map<Integer, Integer> elements = new HashMap<>();

        for (SudokuRow row : board.getBoard()) {
            Set<Integer> allValuesInRow = row.getRow().stream()
                    .map(n -> n.getValue())
                    .collect(Collectors.toSet());
            allValuesInRow.remove(-1);

            elements = lastPossibleInRowCreateElements(elements);
            Map<Integer, Integer> finalElements = elements;

            row.getRow().stream()
                    .flatMap(n -> n.getPossibleValues().stream())
                    .forEach(n -> finalElements.put(n, finalElements.get(n) + 1));

            for (Integer key : finalElements.keySet()) {
                if (finalElements.get(key) == 1) {
                    row.getRow().stream()
                            .filter(n -> n.getPossibleValues().contains(key))
                            .forEach(n -> n.setValue(key));
                } else if (finalElements.get(key) == 0) {
                    if (!allValuesInRow.contains(key) && backtrackList.size()!=0) {
                        needToDoBacktrack = true;
                    } else if (!allValuesInRow.contains(key)) {
                        throw new Exception();
                    }
                }
            }
            allValuesInRow.clear();
        }
    }

    public void removingValuesFromPossibleValuesColumns(SudokuBoard board) {
        List<Integer> valuesInColumn = new ArrayList<>();
        for (int column = 0; column < 9; column++) {
            valuesInColumn.clear();
            for (int row = 0; row < 9; row++) {
                SudokuElement sudokuElement = board.getBoard().get(row).getRow().get(column);
                if (sudokuElement.getValue() != -1) {
                    valuesInColumn.add(sudokuElement.getValue());
                }
            }
            for (int row = 0; row < 9; row++) {
                board.getBoard().get(row).getRow().get(column)
                        .getPossibleValues()
                        .removeAll(valuesInColumn);
            }
        }
    }

    public void lastPossibleInColumn(SudokuBoard board, List<Backtrack> backtrackList) throws Exception {
        Map<Integer, Integer> elements = new HashMap<>();
        List<SudokuElement> allElementsInColumn = new ArrayList<>();
        Set<Integer> allValuesInColumn = new HashSet<>();

        for (int column = 0; column < 9; column++) {
            allValuesInColumn.clear();
            allElementsInColumn.clear();

            for (int row = 0; row < 9; row++) {
                allElementsInColumn.add(board.getBoard().get(row).getRow().get(column));
                Integer value = board.getBoard().get(row).getRow().get(column).getValue();
                if (value != -1) {
                    allValuesInColumn.add(value);
                }
            }

            elements = lastPossibleInRowCreateElements(elements);
            Map<Integer, Integer> finalElements = elements;

            appearOneOrZeroTimesInPossibleNumbers(allElementsInColumn, allValuesInColumn, finalElements,backtrackList);
        }
    }

    public void removingValuesFromPossibleValuesSection(SudokuBoard board) {
        Set<Integer> valuesInSection = new HashSet<>();

        for (int section = 1; section < 10; section++) {
            valuesInSection.clear();

            int finalSection = section;
            valuesInSection = board.getBoard().stream()
                    .flatMap(n -> n.getRow().stream())
                    .filter(n -> n.getSection() == finalSection)
                    .map(n -> n.getValue())
                    .collect(Collectors.toSet());
            valuesInSection.remove(-1);

            Set<Integer> finalValuesInSection = valuesInSection;
            board.getBoard().stream()
                    .flatMap(n -> n.getRow().stream())
                    .filter(n -> n.getSection() == finalSection)
                    .map(n -> n.getPossibleValues())
                    .forEach(n -> n.removeAll(finalValuesInSection));
        }
    }

    public void lastPossibleInSection(SudokuBoard board, List<Backtrack> backtrackList) throws Exception {
        Map<Integer, Integer> elements = new HashMap<>();
        List<SudokuElement> allElementsInSection = new ArrayList<>();
        Set<Integer> allValuesInSection = new HashSet<>();

        for (int section = 1; section < 10; section++) {
            allElementsInSection.clear();
            allValuesInSection.clear();

            int finalSection = section;
            allElementsInSection = board.getBoard().stream()
                    .flatMap(n -> n.getRow().stream())
                    .filter(n -> n.getSection() == finalSection)
                    .collect(Collectors.toList());

            allValuesInSection = allElementsInSection.stream()
                    .map(n -> n.getValue())
                    .collect(Collectors.toSet());
            allValuesInSection.remove(-1);

            elements = lastPossibleInRowCreateElements(elements);
            Map<Integer, Integer> finalElements = elements;

            appearOneOrZeroTimesInPossibleNumbers(allElementsInSection, allValuesInSection, finalElements, backtrackList);
        }
    }

    public void lastPossibleNumberInElement(SudokuBoard board) {
        List<SudokuElement> elements = board.getBoard().stream()
                .flatMap(n -> n.getRow().stream())
                .filter(n -> n.getPossibleValues().size() == 1)
                .collect(Collectors.toList());

        elements.stream()
                .forEach(n -> n.setValue(n.getPossibleValues().get(0)));
    }

    public void removingPossibleValuesFromValues(SudokuBoard board) {
        board.getBoard().stream()
                .flatMap(n -> n.getRow().stream())
                .filter(n -> n.getValue() != -1)
                .forEach(n -> n.getPossibleValues().clear());
    }

    public boolean areAllElementsFilled(SudokuBoard board) {
        boolean isSolved = false;
        List<SudokuElement> numberOfFilledElements = board.getBoard().stream()
                .flatMap(n -> n.getRow().stream())
                .filter(n -> n.getValue() != -1)
                .collect(Collectors.toList());
        if(numberOfFilledElements.size()==81) {
            isSolved=true;
        }
        return isSolved;
    }

    public boolean isSudokuSolvedWell(SudokuBoard board) {
        boolean isSolvedWell = true;

        for(SudokuRow row : board.getBoard()) {
            allInRow = row.getRow().stream()
                    .filter(n -> n.getValue() != -1)
                    .map(n -> n.getValue())
                    .collect(Collectors.toSet());

            if(allInRow.size() != 9) {
                isSolvedWell=false;
                break;
            }
        }

        return isSolvedWell;
    }

    public Backtrack guessingOperation(SudokuBoard board) throws CloneNotSupportedException {
        List<SudokuElement> elementsWithoutValue = board.getBoard().stream()
                .flatMap(n -> n.getRow().stream())
                .filter(n -> n.getValue() == -1)
                .filter(n -> !previouslyUsedElements.contains(n))
                .collect(Collectors.toList());

        for (SudokuElement usedElement : previouslyUsedElements) {
            elementsWithoutValue.stream()
                    .filter(n -> n.getColumn() == usedElement.getColumn() && n.getRow() == usedElement.getRow())
                   .forEach(n -> elementsWithoutValue.remove(n));
        }

        int row = elementsWithoutValue.get(0).getColumn();
        int column = elementsWithoutValue.get(0).getRow();
        List<Integer> values = elementsWithoutValue.get(0).getPossibleValues().stream()
                .collect(Collectors.toList());
        int value = values.get(0);
        SudokuElement newSudokuElement = new SudokuElement(elementsWithoutValue.get(0).getSection(), row, column);
        newSudokuElement.setValue(value);
        previouslyUsedElements.add(newSudokuElement);

        SudokuBoard boardDeepCopy = board.boardDeepCopy();


        return new Backtrack(boardDeepCopy, value, row, column);
    }

    private Map<Integer, Integer> lastPossibleInRowCreateElements(Map<Integer, Integer> elements) {
        elements.clear();
        for (int i = 1; i < 10; i++) {
            elements.put(i, 0);
        }
        return elements;
    }

    private void appearOneOrZeroTimesInPossibleNumbers(List<SudokuElement> allElements,
                                                       Set<Integer> allValues,
                                                       Map<Integer, Integer> finalElements,
                                                       List<Backtrack> backtrackList) throws Exception {
        allElements.stream()
                .flatMap(n -> n.getPossibleValues().stream())
                .forEach(n -> finalElements.put(n, finalElements.get(n) + 1));

        for (Integer key : finalElements.keySet()) {
            if (finalElements.get(key) == 1) {
                allElements.stream()
                        .filter(n -> n.getPossibleValues().contains(key))
                        .forEach(n -> n.setValue(key));
            } else if (finalElements.get(key) == 0) {
                if (!allValues.contains(key) && backtrackList.size()!=0) {
                    needToDoBacktrack = true;
                } else if (!allValues.contains(key)) {
                    throw new Exception();
                }
            }
        }
    }
}
