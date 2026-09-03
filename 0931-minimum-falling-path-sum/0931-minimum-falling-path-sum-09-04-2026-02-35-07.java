class Solution {
    int[][] dp;
    public int help(int[][] mat, int i, int j){
        int n = mat.length;
        if(j < 0 || j >= n) return 1000000;
        if(i >= n) return 0;

        if(dp[i][j] != 1000000) return dp[i][j];

        int left = help(mat, i+1, j-1);
        int down = help(mat, i+1, j);
        int right = help(mat, i+1, j+1);

        return dp[i][j] = mat[i][j] + Math.min(left, Math.min(down, right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], 1000000);
        }

        int ans = 1000000;
        for(int i=0; i<n; i++){
            ans = Math.min(ans, help(matrix, 0, i));
        }

        return ans;
    }
}