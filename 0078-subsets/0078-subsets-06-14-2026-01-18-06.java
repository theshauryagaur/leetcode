class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int sz =(int) Math.pow(2,n);
        List<List<Integer>> ans = new ArrayList<>(sz);
        int x=0;
        while(x < sz){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n ; i++){
                int mask = 1 << i;
                
                if( (mask & x) == mask) list.add(nums[i]);
            }
            ans.add(list);
            x++;
        }
        return ans;
    }
}