class Solution {
    int[][] dp;

    public int helper(int i, int j){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;

        if(dp[i][j] == -1) return 0;
        if(dp[i][j] != -2) return dp[i][j];
        
        dp[i][j] = helper(i-1, j) + helper(i, j-1);

        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        dp = new int[m][n];

        for(int i=0; i<m; i++){            
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = -1;
                else dp[i][j] = -2;
            }            
        }

        return helper(m-1, n-1);
    }
}