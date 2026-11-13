
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] next = new int[n];
        int[] stack = new int[n];
        int top = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (top > 0 && nums[stack[top - 1]] <= nums[i]) {
                top--;
            }

            next[i] = top == 0 ? n : stack[top - 1];
            stack[top++] = i;
        }

        int[][] up = new int[LOG][n];
        long[][] cost = new long[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = next[i];
            cost[0][i] = (long) nums[i] * (next[i] - i)
                    - (prefix[next[i]] - prefix[i]);
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int mid = up[j - 1][i];

                up[j][i] = mid == n ? n : up[j - 1][mid];

                cost[j][i] = cost[j - 1][i];

                if (mid < n) {
                    cost[j][i] += cost[j - 1][mid];
                }
            }
        }

        int left = 0;
        int right = -1;
        long ans = 0;

        for (left = 0; left < n; left++) {
            while (right + 1 < n) {
                int r = right + 1;
                int node = left;
                long operations = 0;

                for (int j = LOG - 1; j >= 0; j--) {
                    if (up[j][node] <= r) {
                        operations += cost[j][node];
                        node = up[j][node];
                    }
                }

                operations += (long) nums[node] * (r - node + 1)
                        - (prefix[r + 1] - prefix[node]);

                if (operations > k) {
                    break;
                }

                right++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
