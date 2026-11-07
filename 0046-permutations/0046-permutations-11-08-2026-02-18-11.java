class Solution {
    List<List<Integer>> ans;
    public void help(int[] nums, int n, int mask, List<Integer> list){
        if(list.size() == n){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<n; i++){
            if((mask & (1 << i)) == 0){
                list.add(nums[i]);
                help(nums, n, mask | (1 << i), list);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        help(nums, nums.length, 0, new ArrayList<>());
        return ans;
    }
}