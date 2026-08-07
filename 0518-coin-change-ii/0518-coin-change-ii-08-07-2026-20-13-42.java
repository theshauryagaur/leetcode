class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        if(amount == 0) return 1;

        int m = amount;
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++) dp[i][0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j] = dp[i-1][j] + (j - coins[i-1] < 0 ? 0 : dp[i][j - coins[i-1]]);
            }
        }

        return dp[n][m];
    }
}