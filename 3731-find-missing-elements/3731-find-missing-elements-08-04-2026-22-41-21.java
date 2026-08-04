class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int i=0;
        int max = nums[n-1];
        int val = nums[0];
        while(val<max){
            if(i>=n || val < nums[i]){
                ans.add(val);
            }
            else i++;
            val++;
        }
        return ans;
    }
}