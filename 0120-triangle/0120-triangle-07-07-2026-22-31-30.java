class Solution {
    int n;
    int[][] dp;
    public int helper(List<List<Integer>> grid, int i, int j){
        if(i >= n) return 0;

        if(dp[i][j] != 4000000) return dp[i][j];

        int left = helper(grid, i+1, j);
        int right = helper(grid, i+1, j+1);

        dp[i][j] = grid.get(i).get(j) + Math.min(left, right);

        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        dp = new int[n][n];
        for(int[] i: dp){
            Arrays.fill(i, 4000000);
        }
        return helper(triangle, 0, 0);
    }
}