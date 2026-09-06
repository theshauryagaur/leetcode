class Solution {
    int m, n;
    char[] a;
    char[] b;
    int[][] dp;

    public int help(int i, int j){
        if(j == n) return 1;
        if(i == m) return 0;

        if(n-j > m-i) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int seq = help(i+1, j);

        if(a[i] == b[j]){
            seq += help(i+1, j+1);
        }

        return dp[i][j] = seq;
    }
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();

        if(n > m) return 0;

        a = s.toCharArray();
        b = t.toCharArray();

        dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);

        return help(0,0);
    }
}