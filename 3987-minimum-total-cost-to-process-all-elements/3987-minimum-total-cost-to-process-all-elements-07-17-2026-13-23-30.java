class Solution {
    public int minimumCost(int[] nums, int k) {
        long sum = 0;
        long cost = 0;
        long MOD = 1_000_000_007L;
        long INV2 = 500_000_004L;

        for(int x: nums){
            sum += x;
        }

        if(sum <= k) return 0;

        cost = (sum - 1)/k;

        long a = cost % MOD;
        long b = (cost+1) % MOD;
        long ans = ( ((a * b) % MOD) * INV2 ) % MOD;
        return (int) ans;
    }
}