class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        int prefixMax = Integer.MIN_VALUE;
        int preSum = 0;
        int suffixMax = Integer.MIN_VALUE;
        int sufSum = 0;

        int[] pre = new int[n];
        int[] suf = new int[n];

        for(int i=0; i<n; i++){
            currSum += nums[i];
            preSum += nums[i];
            sufSum += nums[n-i-1];

            max = Math.max(max, currSum);
            
            if(currSum <= 0) currSum = 0;
            
            prefixMax = Math.max(prefixMax, preSum);
            suffixMax = Math.max(suffixMax, sufSum);

            pre[i] = prefixMax;
            suf[n-i-1] = suffixMax;
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            ans = Math.max(ans, pre[i]+suf[i+1]);
        }

        return Math.max(ans, max);
    }
}