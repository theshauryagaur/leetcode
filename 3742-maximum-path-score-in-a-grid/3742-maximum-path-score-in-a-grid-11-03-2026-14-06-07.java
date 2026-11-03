class Solution {
    int m, n;

    public int help(int[][] grid, int[][][] dp, int k, int i, int j){
        if(i >= m || j >= n) return -1;

        if(dp[i][j][k] != -1000) return dp[i][j][k];

        int x = grid[i][j];
        int cost = (x == 0) ? 0 : 1;

        int score = -1;

        if(i == m-1 && j == n-1){
            if(k - cost >= 0) score = x;
            else score = -1;

            return dp[i][j][k] = score;
        }

        if(k - cost >= 0){
            int rScore = help(grid, dp, k-cost, i, j+1);
            int dScore = help(grid, dp, k-cost, i+1, j);
            
            if(rScore == -1 && dScore == -1) score = -1;
            else score = x + Math.max(rScore, dScore);
        }

        return dp[i][j][k] = score;

    }
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int[][][] dp = new int[m][n][k+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1000);
            }
        }

        return help(grid, dp, k, 0, 0);
    }
}