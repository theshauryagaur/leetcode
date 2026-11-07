class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int ind = Arrays.binarySearch(nums, target);
        if(ind < 0) return new int[]{-1, -1};

        int first = -1;
        int last = -1;

        int L = 0, R = n-1;
        while(L <= R){
            int mid = (L+R)/2;

            if(nums[mid] <= target){
                L = mid+1;
                last = mid;
            }
            else{
                R = mid-1;
            }
        }

        L = 0; R = n-1;
        while(L <= R){
            int mid = (L+R)/2;

            if(nums[mid] < target){
                L = mid+1;
            }
            else{
                R = mid-1;
                first = mid;
            }
        }

        return new int[]{first, last};
    }
}