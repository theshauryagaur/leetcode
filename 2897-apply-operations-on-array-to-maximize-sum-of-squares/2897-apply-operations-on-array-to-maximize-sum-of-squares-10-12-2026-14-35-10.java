class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int n = nums.size();
        
        int MOD = 1_000_000_007;

        int[] cnt = new int[30];
        for(int x: nums){
            for(int i=0; i<30; i++){
                if((x & (1 << i)) != 0){
                    cnt[i]++;
                }
            }
        }

        long ans = 0;
        for(int i=0; i<k; i++){
            long cur = 0;

            for(int j=29; j>=0; j--){
                if(cnt[j] > 0){
                    cur |= (1L << j);
                    cnt[j]--;
                }
            }
            ans = (ans + cur*cur)%MOD;
        }
        return (int) ans;
    } 
}