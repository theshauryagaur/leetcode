class Solution {
    public long countCommas(long n) {
        int dig = String.valueOf(n).length();
        if(dig <= 3) return 0;

        long prevMax = 9;
        long prevNums = 9;
        int comma = 0;
        long ans = 0;

        for(int i=2; i<=dig; i++){
            if((i-1)%3 == 0){
                comma++;
            }
            if(i == dig){
                ans += (long)(n - prevMax) * comma;
                break;
            }
            prevMax = prevMax*10 + 9;
            long currNums = prevNums*10;
            ans += (long) currNums * comma;
            prevNums = currNums;

        }
        return ans;
    }
}