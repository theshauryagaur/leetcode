class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCnt = new int[32];
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            for(int bit = 0; bit<32; bit++){
                bitCnt[bit] += (x & 1);
                x >>= 1;
            }
        } 

        int ans = 0;
        for(int bit = 0; bit<32; bit++){
            ans ^= ((bitCnt[bit] % 3) << bit);
        }
        return ans;
    }
}