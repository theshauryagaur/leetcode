class Solution {
    double[][][] dp;
    int[][] dir = {{2,1}, {2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};
    int len;
    public boolean isValid(int i, int j){
        return !(i<0 || i>=len || j<0 || j>=len);
    }

    public double help(int i, int j, int k){
        if(i<0 || i>=len || j<0 || j>=len) return 0;
        if(k == 0) return 1;

        if(dp[i][j][k] != -1) return dp[i][j][k];
        int valid = 0;
        double prob = 0;

        for(int[] d : dir){
            prob += help(i+d[0] , j+d[1], k-1);
        }
        return dp[i][j][k] = (prob)/8.0;
    }

    public double knightProbability(int n, int k, int row, int column) {
        len = n;
        dp = new double[n+1][n+1][k+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) Arrays.fill(dp[i][j], -1);
        }

        return help(row, column, k);
    }
}