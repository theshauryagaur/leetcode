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
            //( total-summation(0,i-1) )- (n-i)nums[i] + i*nums[i] - summation(0,i-1);
            // this gives |xj-xi| for j>=i    and       this gives |xj-xi| = (xi-xj) for j<i
            ans[i] = total - (n-2*i)*nums[i] - 3*x;
            
            total += nums[i];
        }

        return ans;
    }
}