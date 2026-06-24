class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> sum = new HashMap<>();
        sum.put(0,-1);
        int pre = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            pre += nums[i] == 1 ? 1 : -1;

            if(!sum.containsKey(pre)) sum.put(pre, i);
            else{
                ans = Math.max(ans, i - sum.get(pre));
            }
        }
        return ans;
    }
}