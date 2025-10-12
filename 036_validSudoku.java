class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Each row, column, and box will track digits 1–9
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int num = c - '1'; // convert '1'–'9' → 0–8
                int boxIndex = (i / 3) * 3 + (j / 3);

                // If number already exists in row, column, or box → invalid
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark as seen
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true; // valid if no conflicts found
    }
}
