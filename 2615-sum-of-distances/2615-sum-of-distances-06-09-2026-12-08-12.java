class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;

        // maps each value -> list of indices where it appears
        HashMap<Integer, ArrayList<Integer>> valueToIndices = new HashMap<>();

        // prefixIndexSum[i] = sum of all indices with same value as nums[i], up to and including i
        long[] prefixIndexSum = new long[n];

        // ── Phase 1: build index lists and prefix sums ──────────────────────
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> occurrences = valueToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>());
            occurrences.add(i);

            int occurrenceCount = occurrences.size();
            if (occurrenceCount > 1) {
                int prevIndex = occurrences.get(occurrenceCount - 2);
                prefixIndexSum[i] = prefixIndexSum[prevIndex] + i;  // carry forward previous sum
            } else {
                prefixIndexSum[i] = i;  // first occurrence, sum is just itself
            }
        }

        // ── Phase 2: compute answer for each index ───────────────────────────
        long[] ans = new long[n];

        for (int num : valueToIndices.keySet()) {
            ArrayList<Integer> occurrences = valueToIndices.get(num);
            int sz = occurrences.size();

            if (sz == 1) {
                ans[occurrences.get(0)] = 0;  // only one occurrence, no distances
                continue;
            }

            long totalIndexSum = prefixIndexSum[occurrences.get(sz - 1)];  // sum of ALL indices for this value

            for (int i = 0; i < sz; i++) {
                int ind = occurrences.get(i);

                // prefixIndexSum[ind] = sum of indices to the LEFT of ind, including ind itself
                // rightSum = sum of indices strictly to the right of ind
                long rightSum = totalIndexSum - prefixIndexSum[ind];

                // leftSum = sum of indices strictly to the left of ind
                long leftSum = prefixIndexSum[ind] - ind;

                int rightCount = sz - i - 1;  // number of elements to the right
                int leftCount  = i;           // number of elements to the left

                // distance contribution:
                //   right side: each right index contributes (rightIndex - ind)  →  rightSum - rightCount*ind
                //   left  side: each left  index contributes (ind - leftIndex)   →  leftCount*ind - leftSum
                ans[ind] = (rightSum - (long) rightCount * ind)
                         + ((long) leftCount * ind - leftSum);
            }
        }

        return ans;
    }
}