class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = 0;
        int outOfOrder = 0;

        for(int i=0; i<n; i++){
            if(nums[i] != i){
                outOfOrder++;
                if(outOfOrder == 1){
                    k = nums[i];
                }
                k = (k & nums[i]);
            }
        }
        return k;
    }
}