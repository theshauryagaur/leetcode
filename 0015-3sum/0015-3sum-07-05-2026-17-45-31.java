class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort first!
        HashSet<List<Integer>> triplet = new HashSet<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : nums)
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // skip duplicates for i
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = -(nums[i] + nums[j]);
                if (k < nums[j])
                    continue; // Enforce order: k >= nums[j] avoids mirrors
                if (freq.containsKey(k)) {
                    // count each used
                    int usedI = (nums[i] == k ? 1 : 0) + (nums[i] == nums[j] ? 1 : 0);
                    int usedJ = (nums[j] == k ? 1 : 0) + (nums[j] == nums[i] ? 1 : 0);
                    int usedK = (k == nums[i] ? 1 : 0) + (k == nums[j] ? 1 : 0);
                    usedI += 1;
                    usedJ += 1;
                    usedK += 1; // Each used at least once

                    // how many times does k appear between i and j
                    int countI = usedI, countJ = usedJ, countK = usedK;
                    if (freq.get(nums[i]) >= countI &&
                            freq.get(nums[j]) >= countJ &&
                            freq.get(k) >= countK) {
                        List<Integer> tri = Arrays.asList(nums[i], nums[j], k);
                        // Collections.sort(tri); // Ensure uniqueness
                        //if (!triplet.contains(tri)) {
                            ans.add(tri);
                        //    triplet.add(tri);
                        //}
                    }
                }
            }
        }
        return ans;
    }

}