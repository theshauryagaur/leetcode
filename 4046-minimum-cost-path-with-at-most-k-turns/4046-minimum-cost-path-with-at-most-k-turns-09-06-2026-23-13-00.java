class Solution{
    int[][][][] dp;
    int m, n;
    int[][] d = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int help(int[][] grid, int i, int j, int k, int prevDir){
        if(i == m-1 && j == n-1) return grid[i][j];

        if(prevDir != -1 && dp[i][j][k][prevDir] != -1) return dp[i][j][k][prevDir];
        
        // int cost = Integer.MAX_VALUE;
        int cost = 2000000000;
        
        for(int dir=0; dir<4; dir++){
            int x = i+d[dir][0], y = j+d[dir][1];
            if(x>=0 && x<m && y >=0 && y<n){
                if(dir == prevDir || prevDir == -1) cost = Math.min(cost, help(grid, x, y, k, dir));
                else if(k >= 1) cost = Math.min(cost, help(grid, x, y, k-1, dir));
            }
        }

        if(prevDir != -1) dp[i][j][k][prevDir] = cost + grid[i][j];
        return cost + grid[i][j];
    }
    public int minCost(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        if(k == 0 && m > 1 && n > 1) return -1;
        
        dp = new int[m][n][k+1][4];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int l=0; l<=k; l++)
                Arrays.fill(dp[i][j][l], -1);
            }
        }
        
        return help(grid, 0, 0, k, -1);
    }
}
