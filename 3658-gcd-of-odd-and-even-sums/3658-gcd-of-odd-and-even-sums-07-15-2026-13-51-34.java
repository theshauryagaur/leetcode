class Solution {
    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int evenSum = n*(1+n);
        int oddSum = n*n;

        return gcd(evenSum, oddSum);
    }
}