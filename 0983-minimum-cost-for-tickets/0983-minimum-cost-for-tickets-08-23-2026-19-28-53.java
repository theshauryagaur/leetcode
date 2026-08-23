class Solution {
    int[][] dp;
    public int help(int[] days, int covered, int[] cost, int i){
        if(i >= days.length) return 0;

        if(dp[days[i]][covered] != -1) return dp[days[i]][covered];

        if(covered >= days[i]){
            return dp[days[i]][covered] = help(days, covered, cost, i+1);
        }
    
        int one = cost[0] + help(days, days[i], cost, i+1);
        int week = cost[1] + help(days, days[i] + 6, cost, i+1);
        int month = cost[2] + help(days, days[i] + 29, cost, i+1);

        return dp[days[i]][covered] = Math.min(one, Math.min(week, month));
    }
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[366][400];
        for(int i=1; i<=365; i++){
            Arrays.fill(dp[i], -1);
        }
        return help(days, 0, costs, 0);
    }
}