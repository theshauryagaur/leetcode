class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(nums[Math.abs(nums[i])-1] < 0) ans.add(Math.abs(nums[i]));
            else nums[Math.abs(nums[i])-1] *= -1;
        }
        return ans;
    }
}