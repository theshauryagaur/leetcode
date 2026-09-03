class Solution {
    public int help(int[] nums, int[] dp, int i, int n){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + help(nums, dp, i+2, n);
        int notTake = help(nums, dp, i+1, n);

        return dp[i] = Math.max(take, notTake);
    } 
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        int takeOne = nums[0] + help(nums, dp, 2, n-1);

        Arrays.fill(dp, -1);
        int notTakeOne = help(nums, dp, 1, n);

        return Math.max(takeOne, notTakeOne);
    }
}