class Solution {
    int[] pre;
    int dp[][];
    public int help(int l, int r){
        if(l == r) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        int max = 0;
        for(int i=l; i<r; i++){
            int lHalf = pre[i+1] - pre[l];
            int rHalf = pre[r+1] - pre[i+1];
            if(lHalf > rHalf){
                max = Math.max(max, rHalf + help(i+1, r));
            }
            else if(rHalf > lHalf){
                max = Math.max(max, lHalf + help(l, i));
            }
            else{
                max = Math.max(max, Math.max(rHalf + help(i+1, r), lHalf + help(l, i)));
            }
        }
        return dp[l][r] = max;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n+1][n+1];

        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        pre = new int[n+1];
        pre[0] = 0;
        for(int i=1; i<=n; i++){
            pre[i] = pre[i-1] + stoneValue[i-1];
        }
        return help(0, n-1);
    }
}