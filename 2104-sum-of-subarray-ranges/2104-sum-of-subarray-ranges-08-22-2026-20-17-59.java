class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i=0; i<n; i++){
            int small = nums[i];
            int large = nums[i];
            for(int j=i+1; j<n; j++){
                small = Math.min(small, nums[j]);
                large = Math.max(large, nums[j]);

                ans += large-small;
            }
        }
        return ans;
    }
}