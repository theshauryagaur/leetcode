class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        int oddCount = 0;
        int midChar = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCount++;
                midChar = i;
            }
        }
        
        // A palindromic permutation exists only if at most one character has an odd count
        if (oddCount > 1) {
            return "";
        }
        
        int L = n / 2;
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = cnt[i] / 2;
        }
        
        // Find the maximum prefix length of target's first half that we can perfectly match
        int maxMatch = 0;
        int[] tempFreq = halfFreq.clone();
        while (maxMatch < L) {
            int c = target.charAt(maxMatch) - 'a';
            if (tempFreq[c] > 0) {
                tempFreq[c]--;
                maxMatch++;
            } else {
                break;
            }
        }
        
        // Case 1: Try to perfectly match the first half of target
        if (maxMatch == L) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) {
                sb.append(target.charAt(i));
            }
            String firstHalf = sb.toString();
            String middle = (oddCount == 1) ? String.valueOf((char) (midChar + 'a')) : "";
            String secondHalf = sb.reverse().toString();
            String p = firstHalf + middle + secondHalf;
            
            // If the perfectly matched first half yields a strictly greater palindrome, it's the smallest possible
            if (p.compareTo(target) > 0) {
                return p;
            }
        }
        
        // Case 2: Diverge at some position `pos` < L in the first half
        // Start from the largest valid matching position to keep it lexicographically smallest
        for (int pos = Math.min(L - 1, maxMatch); pos >= 0; pos--) {
            int[] available = halfFreq.clone();
            
            // Subtract frequencies used by the matching prefix target[0...pos-1]
            for (int i = 0; i < pos; i++) {
                available[target.charAt(i) - 'a']--;
            }
            
            int targetChar = target.charAt(pos) - 'a';
            int chosenChar = -1;
            
            // Find the smallest character strictly greater than targetChar available in the pool
            for (int c = targetChar + 1; c < 26; c++) {
                if (available[c] > 0) {
                    chosenChar = c;
                    break;
                }
            }
            
            if (chosenChar != -1) {
                StringBuilder sb = new StringBuilder();
                // 1. Append the matching prefix
                for (int i = 0; i < pos; i++) {
                    sb.append(target.charAt(i));
                }
                
                // 2. Append the strictly greater diverging character
                sb.append((char) (chosenChar + 'a'));
                available[chosenChar]--;
                
                // 3. Greedily append the remaining smallest available characters
                for (int c = 0; c < 26; c++) {
                    while (available[c] > 0) {
                        sb.append((char) (c + 'a'));
                        available[c]--;
                    }
                }
                
                String firstHalf = sb.toString();
                String middle = (oddCount == 1) ? String.valueOf((char) (midChar + 'a')) : "";
                String secondHalf = sb.reverse().toString();
                
                return firstHalf + middle + secondHalf;
            }
        }
        
        return "";
    }
}