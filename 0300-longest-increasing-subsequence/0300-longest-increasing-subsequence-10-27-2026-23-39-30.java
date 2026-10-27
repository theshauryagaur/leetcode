class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n+1];

        for(int i=n-1; i>=0; i--){
            int x = nums[i];
            int max = 0;
            for(int j=i+1; j<n; j++){
                if(nums[j] > x){
                    max = Math.max(dp[j+1], max);
                }
            }

            dp[i+1] = 1 + max;
        }

        int ans = 0;
        for(int x : dp) ans = Math.max(x, ans);
        return ans;
    }
}