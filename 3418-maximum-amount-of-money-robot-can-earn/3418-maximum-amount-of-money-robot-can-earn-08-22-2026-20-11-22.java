class Solution {
    int[][][] dp;
    int m;
    int n;

    public int help(int[][] coin, int i, int j, int k){
        if(i >= m || j >= n) return -2000000000;

        if(i == m-1 && j == n-1){
            return (coin[i][j] >= 0 || k <= 0) ? coin[i][j] : 0;
        }
 
        if(dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];

        int protect = Integer.MIN_VALUE;
        int take = Math.max(help(coin, i+1, j, k), help(coin, i, j+1, k)) + coin[i][j];
        if(k > 0){
            protect = Math.max(help(coin, i+1, j, k-1), help(coin, i, j+1, k-1));
        }

        return dp[i][j][k] = Math.max(take, protect);
    }
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        dp = new int[m][n][3];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        
        return help(coins, 0, 0, 2);
    }
}