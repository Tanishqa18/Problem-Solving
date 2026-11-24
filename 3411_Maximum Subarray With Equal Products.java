
class Solution {
    public int maxLength(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];

                gcd = findGCD(gcd, nums[j]);

                lcm = (lcm / findGCD(lcm, nums[j])) * nums[j];

                if (product == gcd * lcm) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    public long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
