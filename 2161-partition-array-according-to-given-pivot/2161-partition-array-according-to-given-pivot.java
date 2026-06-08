class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
    
        int smaller = 0;
        int greater = n-1;
        for(int i=0; i<n; i++){
            if(nums[i] < pivot){
                ans[smaller++] = nums[i];
            }
            if(nums[n-i-1] > pivot){
                ans[greater--] = nums[n-i-1];
            }
        }

        for(int i=smaller; i<=greater; i++){
            ans[i] = pivot;
        }

        return ans;
    }
}