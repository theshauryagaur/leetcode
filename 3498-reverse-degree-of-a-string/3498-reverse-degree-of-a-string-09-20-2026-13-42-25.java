class Solution {
    public int reverseDegree(String s) {
        int n = s.length();

        int ans = 0;
        for(int i=0; i<n; i++){
            int ch = s.charAt(i);

            ans += (i+1) * ('z'-ch+1);
        }
        return ans;
    }
}