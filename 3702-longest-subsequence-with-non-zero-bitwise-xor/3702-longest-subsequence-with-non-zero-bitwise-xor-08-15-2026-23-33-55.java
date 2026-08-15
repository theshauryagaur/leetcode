class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int max = 0;
        for(int i: nums){
            xor ^= i;
            max = Math.max(max, i);
        }
        return xor == 0 ? (max == 0 ? 0 : n-1) : n;
    }
}