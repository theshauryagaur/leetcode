class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLenBefore = new int[n];
        java.util.Arrays.fill(minLenBefore, Integer.MAX_VALUE);
        
        int sum = 0, left = 0, minLen = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        
        // Find valid sub-arrays and track the minimum length ending at or before each index
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int currLen = right - left + 1;
                minLen = Math.min(minLen, currLen);
                
                // If there is a valid non-overlapping sub-array to the left
                if (left > 0 && minLenBefore[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, minLenBefore[left - 1] + currLen);
                }
            }
            minLenBefore[right] = minLen;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}