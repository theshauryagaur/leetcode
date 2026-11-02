class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int ans = 0;
        int x = nums[n/2];
        for(int i : nums) ans += Math.abs( x - i );

        return ans;
    }
}