class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer,Integer> freq = new HashMap<>();
        int ans = 0;

        for(int i=0; i<n; i++){
            freq.put(nums.get(i),0);
            for(int j=i; j<n; j++){
                freq.put(nums.get(j), freq.getOrDefault(nums.get(j), 0) + 1);
                int sz = freq.size();
                ans += sz*sz;
            }
            freq.clear();
        }
        return ans;
    }
}