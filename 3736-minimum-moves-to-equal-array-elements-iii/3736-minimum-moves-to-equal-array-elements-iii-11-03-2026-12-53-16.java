class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int max = nums[n - 1];

        int ans = 0;
        for(int x : nums) ans += max - x;

        return ans;
    }
}