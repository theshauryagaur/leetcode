class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int maxInd = 0;
        int minInd = 0;

        int max = -1000000;
        int min = 1000000;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                maxInd = i;
                max = nums[i];
            }
            if(nums[i] < min){
                minInd = i;
                min = nums[i];
            }
        }

        if(maxInd < minInd){
            minInd ^= maxInd;
            maxInd ^= minInd;
            minInd ^= maxInd;
        }
        return Math.min(minInd+1+n-maxInd, Math.min(maxInd+1, n-minInd));
    }
}