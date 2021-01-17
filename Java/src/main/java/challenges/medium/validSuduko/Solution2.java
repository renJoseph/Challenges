package challenges.medium.validSuduko;

public class Solution2 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid
    // Sudoku.
    // Memory Usage: 39.1 MB, less than 71.42% of Java online submissions for Valid
    // Sudoku.
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = Character.getNumericValue(board[i][j]);
                    int boxindex = (i / 3) * 3 + j / 3;
                    if (rows[i][n - 1] || columns[j][n - 1] || boxes[boxindex][n - 1])
                        return false;
                    else {
                        rows[i][n - 1] = true;
                        columns[j][n - 1] = true;
                        boxes[boxindex][n - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}
