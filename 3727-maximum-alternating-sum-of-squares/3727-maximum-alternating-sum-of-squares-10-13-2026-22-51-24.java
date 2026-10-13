class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        int odd = n/2;
        long oddSum = 0;
        for(int i=0; i<odd; i++){
            oddSum += nums[i]*nums[i];
        }

        long evenSum = 0;
        for(int i=odd; i<n; i++){
            evenSum += nums[i]*nums[i];
        }

        return evenSum - oddSum;
    }
}