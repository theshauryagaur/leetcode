class Solution {
    long[] fact;
    long MOD = 1_000_000_007;
    public long pow(long base, long exp) {
        long ans = 1l;
        boolean isNegativeExponent = exp < 0;
        exp = Math.abs(exp);
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base * 1l) % MOD;
            }
            base = (base * base * 1l) % MOD;
            exp >>= 1;
        }
        return isNegativeExponent ? (1l / ans) : ans;
    }
 
    public void compute_fact() {
        fact = new long[2001];
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= 2000; i++) {
            fact[i] = (i * 1l * fact[i - 1]) % MOD;
        }
    }
 
    public long nCr(int n, int r) {
        long nr = fact[n];
        long dr = (fact[n - r] * 1l * fact[r]) % MOD;
        long inv = pow(dr, MOD - 2);// using fermat little theorm, inverse(x)=pow(x,m-2) given m is prime
        long ans = (nr * 1l * inv) % MOD;
        return ans;
    }
    public int numberOfSets(int n, int k) {
        if(n == k+1) return 1;
        compute_fact();
        return (int) nCr(n+k-1, 2*k);
    }
}