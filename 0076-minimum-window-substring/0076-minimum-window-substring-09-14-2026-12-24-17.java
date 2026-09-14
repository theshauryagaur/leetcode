class Solution {
    public String minWindow(String a, String t) {
        int n = a.length();
        int cnt = t.length();
        
        if(cnt > n) return "";

        int[] freq = new int[128];
        for(int i=0; i<cnt; i++){
            freq[t.charAt(i)]++;
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int l = 0;
        int r = 0;

        char[] s = a.toCharArray();

        while(r < n){
            if(freq[s[r]] > 0){
                cnt--;
            }

            freq[s[r]]--;
            r++;

            while(cnt == 0){
                if(r - l < minLen){
                    minLen = r - l;
                    start = l;
                }

                freq[s[l]]++;

                if(freq[s[l]] > 0){
                    cnt++;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : a.substring(start, start+minLen);
    }
}