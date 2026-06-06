class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        right[n-1] = 0;

        for(int i=1; i<n; i++){
            left[i] = left[i-1]+nums[i-1];
            right[n-1-i] = right[n-i]+nums[n-i];
        }

        for(int i=0; i<n; i++){
            left[i] = Math.abs(left[i]-right[i]);
        }
        return left;
    }
}