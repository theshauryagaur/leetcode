class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int l = 0, r = 0;
        while(r < n){
            int x = map.getOrDefault(nums[r], 0) + 1;
            map.put(nums[r], x);

            while(map.get(nums[r]) > k){
                int freq = map.getOrDefault(nums[l], 0) - 1;
                map.put(nums[l], freq);

                l++;
            }

            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}