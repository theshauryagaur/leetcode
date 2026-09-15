class Solution {
    public boolean isPalin(String s, int st, int end){
        if(end >= s.length()) return false;
        while(st <= end){
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++; end--;
        }
        return true;
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = k-1;

        int ans = 0;

        while(r < n){
            if(isPalin(s, l, r)){
                ans++;
                l += k;
                r += k;
            }
            else if(isPalin(s, l, r+1)){
                ans++;
                l += k+1;
                r += k+1;
            }
            else {
                l++;
                r++;
            }
        }
        return ans;
    }
}