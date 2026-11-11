class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;

        int both = Math.min(need1, need2);
        int bothCost = Math.min(cost1+cost2, costBoth);

        ans += (long) bothCost * both;

        need1 -= both;
        need2 -= both;

        int minCost1 = Math.min(cost1, costBoth);
        ans += (long) need1 * minCost1;

        int minCost2 = Math.min(cost2, costBoth);
        ans += (long) need2 * minCost2;

        return ans;
    }
}