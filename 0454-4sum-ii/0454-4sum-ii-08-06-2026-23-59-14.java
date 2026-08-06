class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        HashMap<Integer, Integer> map34 = new HashMap<>();
        
        for(int i:nums3){
            for(int j:nums4){
                map34.put(i + j, map34.getOrDefault(i + j, 0) + 1);
            }
        }

        int ans = 0;
        for(int i:nums1){
            for(int j:nums2){
                int req = -(i+j);
                ans += map34.getOrDefault(req, 0);
            }
        }
        return ans;
    }
}