class Solution {
    int m;
    int n;
    private void help(int[][] grid, int[][][] dp, int i, int j, int xor){
        if(i >= m || j >= n) return;

        int x = grid[i][j];
        xor ^= x;

        if(dp[i][j][xor] != 0) return;
        dp[i][j][xor] = 1;

        help(grid, dp, i, j+1, xor);
        help(grid, dp, i+1, j, xor);
        
        return;
    }
    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][][] dp = new int[m+1][n+1][1024];

        help(grid, dp, 0, 0, 0);

        int ans = 0;
        for(int k = 0; k < 1024; k++){
            if(dp[m-1][n-1][k] == 1) return k;
        }
        return 0;
    }
}