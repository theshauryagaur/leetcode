class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int open=0, close=0;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '(') {
                open++;
            }
            else {
                if(i < n-1 && s.charAt(i+1) == ')') i++;
                else ans++;

                if(open > 0) open--;
                else ans++;
            }
        }
        return ans + open*2;
    }
}