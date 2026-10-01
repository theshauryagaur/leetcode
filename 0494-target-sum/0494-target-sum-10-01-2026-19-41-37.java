class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int offset = n*1000;
        int size = 2*offset+1;

        int[] ways = new int[size];

        ways[offset-nums[0]] += 1;
        ways[offset+nums[0]] += 1;

        for(int i=1; i<n; i++){
            int x = nums[i];
            int[] temp = new int[size];
            for(int j=x; j<size-x-1; j++){
                int a = ways[j-x];
                int b = ways[j+x];
                temp[j] += a + b;
            }
            ways = temp;
        }
        return ways[target+offset];
    }
}