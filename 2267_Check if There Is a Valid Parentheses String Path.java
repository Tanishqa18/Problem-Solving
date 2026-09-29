class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Valid parentheses string must have even length
        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];
        if (grid[0][0] == '(') {
            dp[0][0][1] = true;
        } else {
            return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

    
                if (i == 0 && j == 0) {
                    continue;
                }

                int change = (grid[i][j] == '(') ? 1 : -1;

                for (int balance = 0; balance < m + n; balance++) {

                    int newBalance = balance + change;

                    if (newBalance < 0) {
                        continue;
                    }

                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }

                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}
