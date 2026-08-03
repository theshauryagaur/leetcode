class Solution {
    int[] dp;
    int n;
    public int help(int[] stoneValue, int i){
        if(i >= n) return 0;
        
        if(dp[i] != -100000000) return dp[i];

        int one = -100000000;
        int two = -100000000;
        int three = -100000000;

        if(i<n) one = stoneValue[i] - help(stoneValue, i+1);
        if(i<n-1) two = stoneValue[i]+stoneValue[i+1] - help(stoneValue, i+2);
        if(i<n-2) three = stoneValue[i]+stoneValue[i+1]+stoneValue[i+2] - help(stoneValue, i+3);
        //System.out.println(one+" "+two+" "+three);

        dp[i] = Math.max(one, Math.max(two, three));

        return dp[i];
    }
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n];

        Arrays.fill(dp, -100000000);

        help(stoneValue, 0);

        return dp[0] >= 0 ? (dp[0] == 0 ? "Tie" : "Alice") : "Bob";
    }
}