class Solution {
    public double myPow(double x, int n) {
        if(x == 0 || x == 1) return x;

        if(n == Integer.MIN_VALUE){
            return 1.0/x * myPow(x, n+1);
        }

        double ans = 1;
        if(n < 0){
            n = -n;
            x = 1.0/x;
        }
        
        while(n != 0){
            if(n % 2 == 1){
                ans *= x;
            }
            x = x*x;
            n >>= 1;
        }
        return ans;
    }
}