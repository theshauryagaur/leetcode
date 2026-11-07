class Solution {
    List<List<Integer>> ans;
    public void help(int[] nums, int mask, List<Integer> list){
        if(mask == (1 << nums.length) - 1){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if((mask & (1 << i)) == 0){
                list.add(nums[i]);
                help(nums, mask | (1 << i), list);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        help(nums, 0, new ArrayList<>());
        return ans;
    }
}