class Solution {
    public static int findMaxForm(String[] strs, int m, int n) {
        int s = strs.length;
        int[][] dp = new int[m+1][n+1];

        int[] ones = new int[s];
        int[] zeros = new int[s];

        for (int j = 0; j < strs.length; j++) {
           String str = strs[j];
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '1') ones[j]++;
                else zeros[j]++;
            }
        }
        for(int i=1; i <= s; i++){
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if(zeros[i-1] <= j && ones[i-1] <= k) {
                        dp[j][k] = Math.max(dp[j][k], 1 + dp[j-zeros[i-1]][k-ones[i-1]]);
                    }
                    else dp[j][k] = dp[j][k];             
                }
            }
        }
        return dp[m][n];
    }
}