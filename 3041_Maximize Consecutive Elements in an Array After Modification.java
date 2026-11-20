class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : nums) {
            int prev1 = dp.getOrDefault(x - 1, 0);
            int prev2 = dp.getOrDefault(x, 0);

            int len1 = prev1 + 1;
            int len2 = prev2 + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0), len1));
            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), len2));

            ans = Math.max(ans, Math.max(len1, len2));
        }

        return ans;
    }
}
