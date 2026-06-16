class Solution {
    public int smallestEvenMultiple(int n) {
        if(n % 2 ==0) return n;
        for(int i=n; i<500; i++){
            if( i%2 ==0 && i % n == 0) return i;
        }
        return 0;
    }
}