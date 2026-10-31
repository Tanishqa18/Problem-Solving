class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] right = new long[m][n];
        long[][] down = new long[m][n];

        right[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    long ways = (right[i][j] + down[i][j]) % MOD;

                    if (j + 1 < n) {
                        if (grid[i][j + 1] == 0) {
                            right[i][j + 1] =
                                (right[i][j + 1] + ways) % MOD;
                        } else if (i + 1 < m) {
                            down[i + 1][j + 1] =
                                (down[i + 1][j + 1] + ways) % MOD;
                        }
                    }

                    if (i + 1 < m) {
                        if (grid[i + 1][j] == 0) {
                            down[i + 1][j] =
                                (down[i + 1][j] + ways) % MOD;
                        } else if (j + 1 < n) {
                            right[i + 1][j + 1] =
                                (right[i + 1][j + 1] + ways) % MOD;
                        }
                    }
                } else {
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % MOD;
                    }

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) ((right[m - 1][n - 1]
                     + down[m - 1][n - 1]) % MOD);
    }
}
