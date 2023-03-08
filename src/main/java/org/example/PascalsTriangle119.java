package org.example;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle119 {
    public List<Integer> getRow(int rowIndex) {
        return recurse(rowIndex);
    }

    private List<Integer> recurse(int index) {
        if (index == 0) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            return row;
        }

        List<Integer> previousRow = recurse(index - 1);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        for (int i = 0; i < previousRow.size() - 1; i++) {
            int firstNumber = previousRow.get(i);
            int secondNumber = previousRow.get(i + 1);
            currentRow.add(firstNumber + secondNumber);
        }
        currentRow.add(1);
        return currentRow;
    }

    public static void main(String[] args) {
        List<Integer> row = new PascalsTriangle119().getRow(5);
        System.out.println(row);
    }
}
