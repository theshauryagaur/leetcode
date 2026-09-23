class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }

        if(x == total) return n;
        int val = total - x;
        if(val < 0) return -1;
        
        int l = 0, r = 0;
        int sum = 0;
        int len = -1;
        while(r < n){
            sum += nums[r];
            while(l<r && sum > val){
                sum -= nums[l];
                l++;
            }
            if(sum == val) len = Math.max(len, r-l+1);
            r++;
        }
        return len == -1 ? -1 : n - len;
    }
}