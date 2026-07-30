class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int press = 1;
        int ans = 0;
        while(n >= 8){
            n -= 8;
            ans += press*8;
            press++;
        }
        ans += press*n;
        return ans;
    }
}