class Solution {
    public boolean help(int[] nums, int l, int r, int p1, int p2, int turn){
        if(r<l) return p1>=p2 ? true:false;

        if(turn == 0){
            return help(nums, l+1, r, p1+nums[l], p2, turn^1) || help(nums, l, r-1, p1+nums[r], p2, turn^1);
        }
        else{
            // WE USE && here beacause both players play optimally and the player 1 should win regardless of 2's choice
            return help(nums, l+1, r, p1, p2+nums[l], turn^1) && help(nums, l, r-1, p1, p2+nums[r], turn^1);
        }
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return help(nums, 0, n-1, 0, 0, 0);
    }
}