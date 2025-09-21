class Solution {
    String s, p;
    int[][] memo;
    
    public boolean isMatch(String S, String P) {
        s = S; p = P;
        memo = new int[s.length() + 1][p.length() + 1];
        for (int[] row : memo) java.util.Arrays.fill(row, -1);
        return dfs(0, 0);
    }
    
    boolean dfs(int i, int j) {
        if (memo[i][j] != -1) return memo[i][j] == 1;
        boolean ans;
        if (j == p.length()) ans = (i == s.length());
        else {
            boolean fm = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
            if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                ans = dfs(i, j + 2) || (fm && dfs(i + 1, j));
            else
                ans = fm && dfs(i + 1, j + 1);
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
