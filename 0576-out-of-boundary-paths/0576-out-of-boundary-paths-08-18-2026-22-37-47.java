class Solution {
    public int findPaths(int m, int n, int maxMove, int a, int b) {
        if(maxMove == 0) return 0;
        int MOD = 1_000_000_007;

        // 2D DP
        int dp[][] = new int[m+2][n+2];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int x = 0;
                if(i == 1) x++;
                if(i == m) x++;
                if(j == 1) x++;
                if(j == n) x++;
                dp[i][j] = x;
            }
        }

        long ans = dp[a+1][b+1];
        
        for(int k=2; k<=maxMove; k++){
            int temp[][] = new int[m+2][n+2];

            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){

                    int temp1 = (dp[i-1][j] + dp[i+1][j]) % MOD;
                    int temp2 = (dp[i][j-1] + dp[i][j+1]) % MOD;

                    temp[i][j] = (temp1 + temp2) % MOD;
                }
            }
            ans = (ans + temp[a+1][b+1]) % MOD;
            dp = temp;
        }

        return (int) (ans);
    }
}