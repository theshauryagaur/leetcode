class Solution {
    public boolean helper(int[] nums, int[] dp, int i){
        if(i >= nums.length-1) return true;

        if(dp[i] == -1) return false;
        if(dp[i] == 1) return true;

        for(int j=1; j<=nums[i]; j++){
            
            if(helper(nums, dp, i+j)){
                dp[i] = 1;
                return true;
            }

        }
        
        dp[i] = -1;
        return false;

    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return helper(nums, dp, 0);
    }
}