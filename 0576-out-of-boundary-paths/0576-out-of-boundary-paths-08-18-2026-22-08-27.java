class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove == 0) return 0;
        int MOD = 1_000_000_007;

        long dp[][][] = new long[m+2][n+2][maxMove+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int x = 0;
                if(i == 1) x++;
                if(i == m) x++;
                if(j == 1) x++;
                if(j == n) x++;
                dp[i][j][1] = x;
            }
        }

        for(int k=2; k<=maxMove; k++){
            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){

                    dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1] + dp[i][j+1][k-1];
                    
                    dp[i][j][k] %= MOD;
                }
            }
        }
        long ans = 0;
        for(int k=1; k<=maxMove; k++) ans += dp[startRow+1][startColumn+1][k];
        return (int) (ans % MOD);
    }
}