class Solution {
    boolean find(int[] nums, int target, int low, int high) {
        if(low>high){
            return false;
        }
        int mid = low + (high - low) / 2;
        if (target == nums[mid])
            return true;

        if(nums[low] == nums[mid] && nums[mid] == nums[high]){
            return find(nums, target, low, mid-1) || find(nums, target, mid+1, high);
        }

        if (nums[low] <= nums[mid]) {
            if (target < nums[mid] && target >= nums[low])
                high = mid - 1;
            else
                low = mid + 1;
        }

        else {
            if (target > nums[mid] && target <= nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return find(nums, target, low, high);
    }

    public boolean search(int[] nums, int target) {
        return find(nums, target, 0, nums.length-1);
    }
}