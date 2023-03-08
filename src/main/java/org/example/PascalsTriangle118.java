package org.example;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        return recurse(numRows);
    }

    private List<List<Integer>> recurse(int index) {
        List<List<Integer>> output = new ArrayList<>();
        if (index == 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            output.add(row);
            return output;
        }

        output = recurse(index - 1);
        List<Integer> previousRow = output.get(output.size() - 1);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        for (int i = 0; i < previousRow.size() - 1; i++) {
            int firstNumber = previousRow.get(i);
            int secondNumber = previousRow.get(i + 1);
            currentRow.add(firstNumber + secondNumber);
        }
        currentRow.add(1);
        output.add(currentRow);
        return output;
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new PascalsTriangle118().generate(4);
        System.out.println(output);
    }
}
