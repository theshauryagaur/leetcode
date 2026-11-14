class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] preSum = new int[n+1];
        for(int i=0; i<n; i++){
            preSum[i+1] = preSum[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;
        for(int len = l; len <= r; len++){
            for(int i=len; i<=n; i++){
                if(preSum[i] - preSum[i-len] > 0){
                    ans = Math.min(ans, preSum[i] - preSum[i-len]);
                }
            }
        }
        return (ans <= 0 || ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}