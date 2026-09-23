class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int[] pre = new int[n+1];
        for(int i=1; i<=n; i++){
            pre[i] = pre[i-1]+nums[i-1];
        }

        if(x == pre[n]) return n;
        
        int len = -1;
        int val = pre[n] - x;
        for(int i=0; i<=n; i++){
            int ind = Arrays.binarySearch(pre, val + pre[i]);
            if(ind > 0) len = Math.max(len, ind - i);
        }
        return len == -1 ? -1 : n - len;
    }
}