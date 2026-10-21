class Solution {
    int m,n;
    int[][] dp;
    public int help(String s1, String s2, int i, int j){
        if(i == m && j == n) return 0;
        if(i == m) return n-j;
        if(j == n) return m-i;
        
        if(dp[i][j] != -1) return dp[i][j];

        int insert = -1, delete = -1, replace = -1;

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = help(s1, s2, i+1, j+1); // no change
        }
        else{
            insert = help(s1, s2, i, j+1);
            delete = help(s1, s2, i+1, j);
            replace = help(s1, s2, i+1, j+1);
        }
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return help(word1, word2, 0, 0);
    }
}