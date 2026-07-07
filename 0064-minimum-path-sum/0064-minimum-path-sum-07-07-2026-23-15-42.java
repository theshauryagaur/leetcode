class Solution {
    int m, n;
    int[][] dp;
    public int helper(int[][] mat, int i, int j){
        if(j>=n || i>=m) return 8000000;
        if(i == m-1 && j == n-1) return mat[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int right = helper(mat, i, j+1);
        int down = helper(mat, i+1, j);

        dp[i][j] = mat[i][j] + Math.min(right, down);

        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i, -1);
        }

        return helper(grid, 0, 0);
    }
}