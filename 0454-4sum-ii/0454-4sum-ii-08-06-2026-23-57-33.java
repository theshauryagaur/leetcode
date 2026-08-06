class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        HashMap<Integer, Integer> map34 = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map34.put(nums3[i] + nums4[j], map34.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int req = -(nums1[i]+nums2[j]);
                ans += map34.getOrDefault(req, 0);
            }
        }
        return ans;
    }
}