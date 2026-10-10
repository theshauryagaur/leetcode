class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        long[] d = new long[2*100000+1];
        long sum = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            int x = nums1[i];
            int y = nums2[i];

            int diff = Math.abs(x-y);
            d[diff]++;
            sum += diff;
            max = Math.max(max, diff);
        }

        long k = (long) k1+k2;
        if(sum <= k) return 0;

        int i = max;
        while(i>0 && k>0){
            long move = Math.min(k, d[i]);

            d[i] -= move;
            d[i-1] += move;
            k -= move;

            i--;
        }

        long ans = 0;
        for(int j=0; j<=max; j++) ans += (long) d[j]*j*j;
       
        return ans;
    }
}