class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int ans = 1;
        int curr = 1;

        for(int i=1; i<n; i++){
            if(nums[i] - nums[i-1] > 0) curr++;
            else curr = 1;

            ans = Math.max(curr, ans);
        }

        curr = 1;

        for(int i=1; i<n; i++){
            if(nums[i] - nums[i-1] < 0) curr++;
            else curr = 1;

            ans = Math.max(curr, ans);
        }

        return ans;
    }
}