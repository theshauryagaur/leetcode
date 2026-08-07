class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        if(amount == 0) return 1;

        int m = amount;
        int[] dp = new int[m+1];

        dp[0] = 1;

        for(int coin: coins){
            for(int j=coin; j<=m; j++){
                dp[j] += dp[j - coin];
            }
        }

        return dp[m];
    }
}