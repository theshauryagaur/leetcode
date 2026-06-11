class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canReach = new boolean[n];
        for(int i=n-1; i>=0; i--){
            if(i+nums[i] >= n-1) canReach[i] = true;
            else{
                for(int j=1; j<=nums[i]; j++){
                    if(canReach[i+j] == true){
                        canReach[i] = true;
                        break;
                    }
                }
            }
        }
        return canReach[0];
    }
}