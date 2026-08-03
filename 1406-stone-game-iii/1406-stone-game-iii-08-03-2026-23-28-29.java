class Solution {
    int[][] dp;
    int n;
    public int help(int[] stoneValue, int i, int turn){
        if(i >= n) return 0;
        
        if(dp[i][turn] != -100000000) return dp[i][turn];

        int one = -100000000;
        int two = -100000000;
        int three = -100000000;

        if(i<n) one = stoneValue[i] - help(stoneValue, i+1, turn^1);
        if(i<n-1) two = stoneValue[i]+stoneValue[i+1] - help(stoneValue, i+2, turn^1);
        if(i<n-2) three = stoneValue[i]+stoneValue[i+1]+stoneValue[i+2] - help(stoneValue, i+3, turn^1);
        //System.out.println(one+" "+two+" "+three);

        dp[i][turn] = Math.max(one, Math.max(two, three));

        return dp[i][turn];
    }
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n][2];

        for(int i=0; i<n; i++){
            dp[i][0] = -100000000;
            dp[i][1] = -100000000;
        }

        help(stoneValue, 0, 0);

        return dp[0][0] >= 0 ? (dp[0][0] == 0 ? "Tie" : "Alice") : "Bob";
    }
}