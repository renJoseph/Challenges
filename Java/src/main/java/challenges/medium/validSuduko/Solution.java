package challenges.medium.validSuduko;

public class Solution {
    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(isValidSudoku(board));
    }

    // Learn this https://leetcode.com/problems/valid-sudoku/discuss/15587/My-one-pass-O(1)-space-solution-using-Java

    // https://leetcode.com/problems/valid-sudoku/
    // Runtime: 2 ms, faster than 85.36% of Java online submissions for Valid
    // Sudoku.
    // Memory Usage: 38.5 MB, less than 98.81% of Java online submissions for Valid
    // Sudoku.
    public static boolean isValidSudoku(char[][] board) {
        if (!hasValidRows(board))
            return false;
        if (!hasValidColumns(board))
            return false;
        if (!hasValidSquares(board))
            return false;
        return true;
    }

    public static boolean hasValidRows(char[][] board) {
        for (char[] row : board) {
            for (int column = 0; column < 9; column++) {
                if (row[column] == '.')
                    continue;
                for (int testColumn = column + 1; testColumn < 9; testColumn++) {
                    if (row[column] == row[testColumn])
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean hasValidColumns(char[][] board) {
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (board[row][column] == '.')
                    continue;
                for (int testRow = row + 1; testRow < 9; testRow++) {
                    if (board[row][column] == board[testRow][column])
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean hasValidSquares(char[][] b) {
        final char[][] squares = { { b[0][0], b[0][1], b[0][2], b[1][0], b[1][1], b[1][2], b[2][0], b[2][1], b[2][2] },
                { b[0][3], b[0][4], b[0][5], b[1][3], b[1][4], b[1][5], b[2][3], b[2][4], b[2][5] },
                { b[0][6], b[0][7], b[0][8], b[1][6], b[1][7], b[1][8], b[2][6], b[2][7], b[2][8] },
                { b[3][0], b[3][1], b[3][2], b[4][0], b[4][1], b[4][2], b[5][0], b[5][1], b[5][2] },
                { b[3][3], b[3][4], b[3][5], b[4][3], b[4][4], b[4][5], b[5][3], b[5][4], b[5][5] },
                { b[3][6], b[3][7], b[3][8], b[4][6], b[4][7], b[4][8], b[5][6], b[5][7], b[5][8] },
                { b[6][0], b[6][1], b[6][2], b[7][0], b[7][1], b[7][2], b[8][0], b[8][1], b[8][2] },
                { b[6][3], b[6][4], b[6][5], b[7][3], b[7][4], b[7][5], b[8][3], b[8][4], b[8][5] },
                { b[6][6], b[6][7], b[6][8], b[7][6], b[7][7], b[7][8], b[8][6], b[8][7], b[8][8] } };
        return hasValidRows(squares);
    }
}
