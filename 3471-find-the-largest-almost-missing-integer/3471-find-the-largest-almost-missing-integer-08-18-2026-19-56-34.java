class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        int x = nums[0], y = nums[n-1];
        
        int max = 0;
        for(int i: nums) max = Math.max(max, i);

        HashMap<Integer,Integer> set = new HashMap<>();
        for(int i:nums){
            set.put(i, set.getOrDefault(i, 0) + 1);
        }

        int maxOne = -1;
        for(int i: set.keySet()){
            if(set.get(i) == 1) maxOne = Math.max(i, maxOne);
        }
        
        if(k == 1) return maxOne;

        if(k == n) return max;

        int one = set.get(x);
        int two = set.get(y);

        if(one == 1 && two == 1) return Math.max(x, y);
        if(one == 1 && two != 1) return x;
        if(one != 1 && two == 1) return y;
        return -1;
    }
}