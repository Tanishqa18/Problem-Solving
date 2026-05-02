class Solution {

    // Helper method for linear robbery
    public int robLinear(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude last house
        int option1 = robLinear(nums, 0, n - 2);

        // Case 2: Exclude first house
        int option2 = robLinear(nums, 1, n - 1);

        return Math.max(option1, option2);
    }
}
