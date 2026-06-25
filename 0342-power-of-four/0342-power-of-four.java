class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        if(n<=3) return false;
        if((n&(n-1))==0 && ((n & 0xAAAAAAAA) == 0)) return true;
        return false;
    }
}