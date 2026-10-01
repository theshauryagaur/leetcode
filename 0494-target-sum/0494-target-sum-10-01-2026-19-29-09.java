class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int offset = n*1000;
        int size = 2*offset+1;

        int[][] ways = new int[n][size];

        ways[0][offset-nums[0]] += 1;
        ways[0][offset+nums[0]] += 1;

        for(int i=1; i<n; i++){
            int x = nums[i];
            for(int j=x; j<size-x-1; j++){
                ways[i][j] += ways[i-1][j-x] + ways[i-1][j+x];
            }
        }
        return ways[n-1][target+offset];
    }
}