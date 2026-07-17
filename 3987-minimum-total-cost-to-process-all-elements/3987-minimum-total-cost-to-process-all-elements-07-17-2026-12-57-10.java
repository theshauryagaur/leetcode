class Solution {
    public int minimumCost(int[] nums, int k) {
        long res = k;
        long cost = 0;
        long mod = 1_000_000_007;
        
        for(int i=0; i<nums.length; i++){
            if(res < nums[i]){
                long n = (nums[i] - res + k-1)/k;
                res = (res + n*k - nums[i]);
                cost += n;
                cost %= mod;
            }
            else res -= nums[i];
        }
        long ans = (((cost%mod)*((cost+1)%mod))/2)%mod;
        return (int) ans;
    }
}