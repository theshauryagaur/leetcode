class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int[] pre = new int[n+1];
        for(int i=1; i<=n; i++){
            pre[i] = pre[i-1]+nums[i-1];
        }

        if(x == pre[n]) return n;
        
        int l = 0, r = 0;
        int sum = 0;
        int val = pre[n] - x;
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