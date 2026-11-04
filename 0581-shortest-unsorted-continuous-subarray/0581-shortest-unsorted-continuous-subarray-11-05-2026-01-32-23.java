class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int l = -1, r = -1;
        int i = n-1;
        while(i > 0){
            int x = nums[i--];

            if(x >= nums[i]) continue;
            else {
                while(i>=0 && nums[i] > x){
                    l = i;
                    i--;
                }
            }
        }

        i = 0;
        while(i < n-1){
            int x = nums[i++];

            if(x <= nums[i]) continue;
            else {
                while(i<n && nums[i] < x){
                    r = i;
                    i++;
                }
            }
        }
        
        if(l == -1){
            if(r == -1) return 0;
            return r + 1;
        }
        else {
            if(r == -1) return n - l;
        }
        return  r - l + 1;
    }
}