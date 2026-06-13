class Solution {
    public int minBitFlips(int start, int goal) {
        int n = start ^ goal;
        int cnt = 0;
        //Brian Kernighan algo 
        while(n != 0){
            n = n & (n-1); // clears lowest set bit in each iteration
            cnt ++;
        }

        return cnt;
    }
}