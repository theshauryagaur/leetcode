class Solution {
    int n;
    int[] pre;
    public int help(int[] piles, int[][] dp, int i, int M){
        if(i >= n) return 0;

        if(dp[i][M] != -10000000) return dp[i][M];

        int score = Integer.MIN_VALUE;
        for(int x=1; i+x<=n && x<=2*M; x++){
            int stones = pre[i+x] - pre[i];
            score = Math.max(score, stones - help(piles, dp, i+x, Math.max(M, x)));
        }
        dp[i][M] = score;
        return dp[i][M];
    }
    public int stoneGameII(int[] piles) {
        n = piles.length;
        pre = new int[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i] + piles[i];
        }
        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -10000000);

        int diff = help(piles, dp, 0, 1);
        return (pre[n] + diff)/2;
    }
}