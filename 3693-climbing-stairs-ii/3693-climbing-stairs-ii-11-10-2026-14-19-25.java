class Solution {
    public int climbStairs(int n, int[] costs) {
        int INF = (int) 1e9;
        int one = 0, two = INF, three = INF;

        for(int i=1; i<=n; i++){
            int oneStep = i >= 1 ? one + 1 : INF;
            int twoStep = i >= 2 ? two + 4 : INF;
            int threeStep = i >= 3 ? three + 9 : INF;

            int cost = costs[i-1] + Math.min(oneStep, Math.min(twoStep, threeStep));
            
            three = two;
            two = one;
            one = cost;
        }

        return one;
    }
}