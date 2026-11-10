class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        int INF = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int one = i >= 1 ? dp[i-1] + 1 : INF;
            int two = i >= 2 ? dp[i-2] + 4 : INF;
            int three = i >= 3 ? dp[i-3] + 9 : INF;

            dp[i] = costs[i-1] + Math.min(one, Math.min(two, three));
        }

        return dp[n];
    }
}