class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int max = -1;
        for(int x : nums) max = Math.max(max, x);

        int ans = 0;
        for(int x : nums) ans += max - x;

        return ans;
    }
}