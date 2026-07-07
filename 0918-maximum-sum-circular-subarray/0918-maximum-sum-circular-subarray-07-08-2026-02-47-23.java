class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int currMax = 0;

        int min = Integer.MAX_VALUE;
        int currMin = 0;

        int total = 0;

        for(int i=0; i<n; i++){
            currMax += nums[i];
            max = Math.max(max, currMax);
            
            currMin += nums[i];
            min = Math.min(min, currMin);
            
            if(currMax <= 0) currMax = 0;
            if(currMin >= 0) currMin = 0;
            
            total += nums[i];
        }

        if(max > 0) return Math.max(max, total-min);
        return max;
    }
}