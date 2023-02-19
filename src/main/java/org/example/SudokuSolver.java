
package org.example;
public class SudokuSolver {
    private char[][] board;
    public void solveSudoku(char[][] board) {
       this.board = board;
       recurse();
    }

    private void recurse() {
        boolean added = false;
        for (char c = '1'; c <= '9'; c++) {
            for (int row = 0; row < 9; row++) {
                added = processRow(c, row) || added;
            }
            for (int col = 0; col < 9; col++) {
                added = processCol(c, col) || added;
            }
            for (int row = 0; row < 9; row += 3) {
                for (int col = 0; col < 9; col += 3) {
                    added = processCube(c, row, col) || added;
                }
            }
        }

        if (added) {
            recurse();
        }
    }

    private boolean processRow(char charToPut, int row) {
        int colIndex = -1;
        for (int col = 0; col < 9; col++) {
            if (!canPutNumber(charToPut, row, col) || this.board[row][col] != '.') {
                continue;
            } if (colIndex != -1) {
                return false;
            }
            colIndex = col;
        }
        if (colIndex == -1) {
            return false;
        }

        this.board[row][colIndex] = charToPut;
        System.out.println("ROW: Added " + charToPut + " at row: " + row + " col: " + colIndex);
        return true;
    }

    private boolean processCol(char charToPut, int col) {
        int rowIndex = -1;
        for (int row = 0; row < 9; row++) {
            if (!canPutNumber(charToPut, row, col) || this.board[row][col] != '.') {
                continue;
            }
            if (rowIndex != -1) {
                return false;
            }
            rowIndex = row;
        }
        if (rowIndex == -1) {
            return false;
        }

        this.board[rowIndex][col] = charToPut;
        System.out.println("COL: Added " + charToPut + " at row: " + rowIndex + " col: " + col);
        return true;
    }
    private boolean processCube(char charToPut, int row, int col) {
        int startingRow = row / 3 * 3;
        int endingRow = startingRow + 2;
        int startingCol = col / 3 * 3;
        int endingCol = startingCol + 2;

        int rowIndex = -1;
        int colIndex = -1;
        for (int i = startingRow; i <= endingRow; i++) {
            for (int j = startingCol; j <= endingCol; j++) {
                if (this.board[i][j] != '.' || !canPutNumber(charToPut, i, j) ) {
                    continue;
                }
                if (rowIndex != -1 || colIndex != -1) {
                    return false;
                }
                rowIndex = i;
                colIndex = j;
            }
        }
        if (rowIndex == -1 || colIndex == -1) {
            return false;
        }

        this.board[rowIndex][colIndex] = charToPut;
        System.out.println("CUBE: Added " + charToPut + " at row: " + rowIndex + " col: " + col);
        return true;
    }
    private boolean canPutNumber(char charToPut, int row, int col) {
        boolean checkRow = rowContainsNumber(charToPut, row);
        boolean checkCol = colContainsNumber(charToPut, col);
        boolean checkCube = cubeContainsNumber(charToPut, row, col);
        return !checkRow && !checkCol && !checkCube;
    }

    private boolean rowContainsNumber(char c, int row) {
        for (int i = 0; i < 9; i++) {
            if (this.board[row][i] == c) {
                return true;
            }
        }

        return false;
    }

    private boolean colContainsNumber(char c, int col) {
        for (int i = 0; i < 9; i++) {
            if (this.board[i][col] == c) {
                return true;
            }
        }

        return false;
    }

    private boolean cubeContainsNumber(char c, int row, int col) {
        int startingRow = row / 3 * 3;
        int endingRow = startingRow + 2;
        int startingCol = col / 3 * 3;
        int endingCol = startingCol + 2;

        for (int i = startingRow; i <= endingRow; i++) {
            for (int j = startingCol; j <= endingCol; j++) {
                if (this.board[i][j] == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver ss = new SudokuSolver();
        ss.solveSudoku(board);
        for (char[] row : board) {
            String rowString = "";
            for (char c : row) {
                rowString += c;
            }
            System.out.println(rowString);
        }
    }
}
