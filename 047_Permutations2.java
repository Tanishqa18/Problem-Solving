class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    void solve(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            cur.add(nums[i]);
            solve(nums, used, cur, ans);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
