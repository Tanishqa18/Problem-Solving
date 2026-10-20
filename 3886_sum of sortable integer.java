class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
                break;
            }
        }

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            if (k == 1) {
                if (sorted) {
                    ans += 1;
                }
                continue;
            }

            boolean possible = true;

            for (int start = 0; start < n; start += k) {
                int descents = 0;

                for (int j = start; j < start + k; j++) {
                    int next = (j + 1 == start + k) ? start : j + 1;

                    if (nums[j] > nums[next]) {
                        descents++;
                    }
                }

                if (descents > 1) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans += k;
            }
        }

        return ans;
    }
}
