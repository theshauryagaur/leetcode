class Solution {
    int[][] dp;
    public int help(int[] days, int covered, int[] cost, int i){
        if(i >= days.length || covered >= 365) return 0;

        int x = days[i];

        if(dp[i][covered] != -1) return dp[i][covered];

        if(covered >= x){
            return dp[i][covered] = help(days, covered, cost, i+1);
        }
    
        int one = cost[0] + help(days, x, cost, i+1);
        int week = cost[1] + help(days, x + 6, cost, i+1);
        int month = cost[2] + help(days, x + 29, cost, i+1);

        return dp[i][covered] = Math.min(one, Math.min(week, month));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        dp = new int[n][366];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return help(days, 0, costs, 0);
    }
}