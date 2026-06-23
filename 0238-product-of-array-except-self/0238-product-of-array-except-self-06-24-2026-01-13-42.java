class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, 1);
        int pre = 1;
        for(int i=0; i<n; i++){
            res[i] = res[i]*pre;
            pre *= nums[i];
        }

        int suf = 1;
        for(int i=n-1; i>=0; i--){
            res[i] *= suf;
            suf *= nums[i];
        }
        return res;
    }
}