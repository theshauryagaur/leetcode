class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        if(amount == 0) return 1;

        int m = amount;
        int[] dp = new int[m+1];

        dp[0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[j] = dp[j] + (j - coins[i-1] < 0 ? 0 : dp[j - coins[i-1]]);
            }
        }

        return dp[m];
    }
}