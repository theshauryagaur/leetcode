class Solution {
    int[][] dp;

    public int helper(int i, int j){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i<0 || j<0) return 0;

        if(dp[i][j] != 0) return dp[i][j]; 

        dp[i][j] = helper(i-1,j) + helper(i,j-1);

        return dp[i][j];
    }
    
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(m-1, n-1);
    }
}