package org.example;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private List<List<String>> output = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }

        recurse(board, 0);
        return output;
    }

    private boolean recurse(List<String> board, int rowI) {
        if (rowI == board.size()) {
            output.add(new ArrayList<>(board));
            return false;
        }
        String row = board.get(rowI);
        for (int col = 0; col < row.length(); col++) {
            if (canPut(board, rowI, col)) {
                row = row.substring(0, col) + 'Q' + row.substring(col + 1);
                board.set(rowI, row);
                if (recurse(board, rowI + 1)) {
                    return true;
                } else {
                    row = row.substring(0, col) + '.' + row.substring(col + 1);
                    board.set(rowI, row);
                }
            }
        }
        return false;
    }

    private boolean canPut(List<String> board, int row, int col) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(row).charAt(i) == 'Q') {
                return false;
            }
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < board.size(); i++) {
            int j = col - row + i;
            if (j >= 0 && j < board.size()) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            int k = col + row - i;
            if (k >= 0 && k < board.size()) {
                if (board.get(i).charAt(k) == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
