class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int x: nums) set.add(x);

        int x = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]+1) x += nums[i];
            else break;
        }

        while(set.contains(x)) x++;
        return x;
    }
}