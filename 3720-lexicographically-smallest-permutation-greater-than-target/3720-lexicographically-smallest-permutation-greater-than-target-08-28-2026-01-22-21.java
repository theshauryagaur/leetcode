class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] originalCount = new int[26];
        for (char c : s.toCharArray()) {
            originalCount[c - 'a']++;
        }

        // Search for the divergence point from right to left
        for (int i = n - 1; i >= 0; i--) {
            int[] count = originalCount.clone();
            boolean canMatchPrefix = true;
            char[] ans = new char[n];
            
            // 1. Verify if we can perfectly match target up to index i-1
            for (int j = 0; j < i; j++) {
                char req = target.charAt(j);
                if (count[req - 'a'] == 0) {
                    canMatchPrefix = false;
                    break;
                }
                count[req - 'a']--;
                ans[j] = req;
            }
            
            if (!canMatchPrefix) continue;
            
            // 2. Find the smallest available character strictly greater than target[i]
            boolean foundGreater = false;
            for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {
                if (count[c] > 0) {
                    ans[i] = (char) (c + 'a');
                    count[c]--;
                    foundGreater = true;
                    break;
                }
            }
            
            if (!foundGreater) continue;
            
            // 3. Fill the remaining suffix with leftover characters in standard alphabetical order
            int idx = i + 1;
            for (int c = 0; c < 26; c++) {
                while (count[c] > 0) {
                    ans[idx++] = (char) (c + 'a');
                    count[c]--;
                }
            }
            
            return new String(ans);
        }
        
        return "";
    }
}