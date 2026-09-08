class Solution {
    public int countCommas(int n) {
        if(n < 1000) return 0;

        int ans = 1;
        int x = 1000;
        int comma = 1;
        int i = 1;

        while(x*10 < n){
            ans += (x*10 - x) * comma;
            i++;
            if(i%3 == 0) comma++;
            x *= 10;
        }
        ans += (n - x) * comma;
        return ans;
    }
}