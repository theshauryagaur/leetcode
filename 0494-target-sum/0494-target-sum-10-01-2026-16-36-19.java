class Solution {
    int ans = 0;
    public void ways(int[] nums, int target, int sum, int i){
        if(i == nums.length){
            if(sum == target) ans++;
            return;
        }

        ways(nums, target, sum + nums[i], i+1);
        ways(nums, target, sum - nums[i], i+1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        ways(nums, target, 0, 0);
        return ans;
    }
}