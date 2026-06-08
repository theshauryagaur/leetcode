class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;

        int total = 0;
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++){
            ans[i] = total;
            total += nums[i];
        }
        for(int i=0; i<n; i++){
            int x = ans[i];
            ans[i] = total - (n-2*i)*nums[i] - 3*x;
            
            total += nums[i];
        }

        return ans;
    }
}