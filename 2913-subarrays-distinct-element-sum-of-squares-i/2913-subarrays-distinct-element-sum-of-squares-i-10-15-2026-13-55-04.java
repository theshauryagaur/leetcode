class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for(int i=0; i<n; i++){
            HashSet<Integer> freq = new HashSet<>();
            for(int j=i; j<n; j++){
                freq.add(nums.get(j));
                int sz = freq.size();
                ans += sz*sz;
            }
        }
        return ans;
    }
}