class Solution {
    int m, n;
    int[][] dp;
    public int help(String s, int i, int j){
        if(j<i) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(i == j) return 1;

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + help(s, i+1, j-1);
        }
        return dp[i][j] = Math.max(help(s, i+1, j), help(s, i, j-1));
    }
    public int minInsertions(String s) {
        m = s.length();

        dp = new int[m][m];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return m - help(s, 0, m-1);
    }
}