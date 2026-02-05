class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> path,
                           List<List<Integer>> result) {

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, result);
            path.remove(path.size() - 1);
        }
    }
}
