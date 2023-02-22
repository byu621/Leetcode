package org.example;

import java.util.ArrayList;
import java.util.List;

public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        boolean output = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<Integer> omit = new ArrayList<>();
                    omit.add(i * board[0].length + j);
                    output |= recurse(board, word, i, j, 1, omit);
                }
            }
        }

        return output;
    }

    private boolean recurse(char[][] board, String word, int row, int col, int index, List<Integer> omit) {
        if (index == word.length()) {
            return true;
        }

        int currentPosition = board[0].length * row + col;
        List<Integer> positions = new ArrayList<>();
        positions.add(currentPosition - board[0].length);
        positions.add(currentPosition + board[0].length);
        if (col != 0) {
            positions.add(currentPosition - 1);
        }
        if (col != board[0].length - 1) {
            positions.add(currentPosition + 1);
        }
        boolean isComplete = false;
        for (int position : positions) {
            int i = position / board[0].length;
            int j = position % board[0].length;
            boolean outOfBounds = i < 0 || i >= board.length || j < 0 || j >= board[0].length;
            if (outOfBounds) {
                continue;
            }
            boolean inOmit = omit.contains(position);
            boolean notSequence = board[i][j] != word.charAt(index);
            if (inOmit || notSequence) {
                continue;
            }
            omit.add(position);
            isComplete |= recurse(board, word, i, j, index + 1, omit);
            omit.remove(omit.size() - 1);
        }
        return isComplete;
    }

    public static void main(String[] args) {
        char[][] wow = new char[][]{{'a', 'b'}, {'c', 'd'}};
        new WordSearch79().exist(wow, "abcd");
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        new WordSearch79().exist(board, "ABCCED");
    }
}
