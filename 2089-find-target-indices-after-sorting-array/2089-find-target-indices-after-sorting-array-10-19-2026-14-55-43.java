class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int smaller = 0, cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < target) smaller++;
            else if(nums[i] == target) cnt++;
        }

        for(int i=0; i<cnt; i++){
            ans.add(smaller+i);
        }
        return ans;
    }
}