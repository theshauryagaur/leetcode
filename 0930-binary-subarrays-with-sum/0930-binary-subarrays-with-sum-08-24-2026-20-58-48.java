class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int curr = 0;
        map.put(0, 1);
        for(int i=0; i<n; i++){
            curr += nums[i];
            ans += map.getOrDefault(curr - goal, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
}