package org.example;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SudokuSolverRecurse {
    public void solveSudoku(char[][] board) {
        recurse(board);
    }

    private boolean recurse(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                Set<Character> possibilities = Stream.of('1', '2', '3', '4', '5', '6', '7', '8', '9').collect(Collectors.toSet());
                processPossibilities(board, possibilities, i, j);
                if (possibilities.size() == 0) {
                    return false;
                }
                for (char c : possibilities) {
                    board[i][j] = c;
                    if (recurse(board)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }

                }
                return false;
            }
        }
        return true;
    }

    private void processPossibilities(char[][] board, Set<Character> possibilities, int row, int col) {
        for (int i = 0; i < 9; i++) {
            possibilities.remove(board[row][i]);
            possibilities.remove(board[i][col]);
        }
        int startingRow = row / 3 * 3;
        int startingCol = col / 3 * 3;
        for (int i = startingRow; i <= startingRow + 2; i++) {
            for (int j = startingCol; j <= startingCol + 2; j++) {
                possibilities.remove(board[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolverRecurse ss = new SudokuSolverRecurse();
        ss.solveSudoku(board);
        for (char[] row : board) {
            StringBuilder rowString = new StringBuilder();
            for (char c : row) {
                rowString.append(c);
            }
            System.out.println(rowString);
        }

    }
}
