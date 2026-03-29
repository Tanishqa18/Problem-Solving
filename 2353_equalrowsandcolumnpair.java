class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        // Step 1: Store rows in map
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row += grid[i][j] + ",";
            }
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        int count = 0;

        // Step 2: Check columns
        for (int j = 0; j < n; j++) {
            String col = "";
            for (int i = 0; i < n; i++) {
                col += grid[i][j] + ",";
            }

            if (map.containsKey(col)) {
                count += map.get(col);
            }
        }

        return count;
    }
}
