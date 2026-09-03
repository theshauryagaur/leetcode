class Solution { 
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        for(int j=0; j<n; j++){
            dp[n-1][j] = matrix[n-1][j];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int left = j-1 >= 0 ? dp[i+1][j-1] : 1000000;
                int down = dp[i+1][j];
                int right = j+1 < n ? dp[i+1][j+1] : 1000000;

                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));
            }
        }

        int ans = 1000000;
        for(int j=0; j<n; j++){
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }
}