class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;

        int common = Math.min(need1, need2);

        if (costBoth < cost1 + cost2) {
            ans += 1L * common * costBoth;
        } else {
            ans += 1L * common * (cost1 + cost2);
        }

        need1 -= common;
        need2 -= common;

        ans += 1L * need1 * Math.min(cost1, costBoth);
        ans += 1L * need2 * Math.min(cost2, costBoth);

        return ans;
    }
}
