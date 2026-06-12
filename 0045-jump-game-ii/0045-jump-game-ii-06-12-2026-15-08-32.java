class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int steps = 0;
        int curr = 0;
        int farthest = 0;
        for(int i=0; i<n-1; i++){
            farthest = Math.max(farthest, i+nums[i]);

            if(i == curr){
                steps ++;
                curr = farthest;
            }
        }
        return steps;
    }
}