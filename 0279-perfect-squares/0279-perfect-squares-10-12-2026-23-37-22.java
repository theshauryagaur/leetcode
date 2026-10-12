class Solution {
    int[] dp;
    public int helper(int n){
        if(n < 4) return n;

        if(dp[n] != 0) return dp[n];

        int ans = n;
        for(int i=1; i*i<=n; i++){
            int req = 1 + helper(n-i*i);
            ans = Math.min(ans, req);
            if(req == 1) break;
        }
        dp[n] = ans;

        return dp[n];

    }
    public int numSquares(int n) {
        dp = new int[n+1];

        for(int i=1; i*i<=n; i++){
            dp[i*i] = 1;
            if(i*i == n) return 1;
        }

        return helper(n);
    }
}