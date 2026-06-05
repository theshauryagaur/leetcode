class Solution {
    public static int findMaxForm(String[] strs, int m, int n) {
        int s = strs.length;
        int[][][] dp = new int[s+1][m+1][n+1];

        int[] ones = new int[s];
        int[] zeros = new int[s];

        for (int j = 0; j < strs.length; j++) {
           String str = strs[j];
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '1') ones[j]++;
                else zeros[j]++;
            }
        }

        for(int i=1; i<=s; i++){
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {

                    if(zeros[i-1] <= j && ones[i-1] <= k) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], 1+dp[i-1][j-zeros[i-1]][k-ones[i-1]]);
                    }
                    else dp[i][j][k] = dp[i-1][j][k];
                    
                }
            }
        }
        return dp[s][m][n];
    }
}