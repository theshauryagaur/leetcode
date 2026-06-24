class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> preMod = new HashMap<>();
        preMod.put(0,-1);
        int rem = 0;
        for(int i=0; i<n; i++){
            rem = rem+nums[i];
            rem %= k;

            if(preMod.containsKey(rem)){
                if(i - preMod.get(rem) >= 2) return true;
            }
            else preMod.put(rem,i); 
        }
        return false;
    }
}