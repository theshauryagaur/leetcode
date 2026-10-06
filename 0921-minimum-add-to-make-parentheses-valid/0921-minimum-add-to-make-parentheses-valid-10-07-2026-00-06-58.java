class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;

        int ans = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') open++;
            else close++;

            if(close > open) {
                ans++;
                open++;
            }
        }
        ans += open - close;
        return ans;
    }
}