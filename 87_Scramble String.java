class Solution {

    Boolean[][][] dp;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        dp = new Boolean[n][n][n + 1];

        return solve(s1, s2, 0, 0, n);
    }

    private boolean solve(String s1, String s2, int i, int j, int len) {

        if (dp[i][j][len] != null) {
            return dp[i][j][len];
        }

        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return dp[i][j][len] = true;
        }

        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                return dp[i][j][len] = false;
            }
        }

        for (int k = 1; k < len; k++) {

            boolean noSwap =
                    solve(s1, s2, i, j, k) &&
                    solve(s1, s2, i + k, j + k, len - k);

            boolean swap =
                    solve(s1, s2, i, j + len - k, k) &&
                    solve(s1, s2, i + k, j, len - k);

            if (noSwap || swap) {
                return dp[i][j][len] = true;
            }
        }

        return dp[i][j][len] = false;
    }
}
