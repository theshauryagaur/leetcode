class Solution {
    public int helper(int[] nums, int[] dp, int i){
        if(i >= nums.length-1) return 0;
        if(nums[i] == 0) return Integer.MAX_VALUE;
        
        if(dp[i] != -1) return dp[i];
        int steps = Integer.MAX_VALUE;

        for(int j=1; j<=nums[i]; j++){
            if(i+j <= nums.length){
                int x = helper(nums, dp, i+j);
                if( x != Integer.MAX_VALUE){
                    steps = Math.min(steps, 1+helper(nums, dp, i+j));
                }
            }
            else break;
        }
        
        dp[i] = steps;
        return dp[i];

    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, dp, 0);
    }
}