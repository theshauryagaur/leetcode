class Solution {
    public class RollingHash{
        private final long[] power;
        private final long[] hash;
        private final long base;
        private final long mod;
        private final int k;
        
        RollingHash(String s, long base, long mod, int k){
            int n = s.length();

            this.base = base;
            this.mod = mod;
            this.k = k;

            power = new long[n+1];
            hash = new long[n+1];

            power[0] = 1;
            for(int i=0; i<n; i++){
                power[i+1] = power[i] * base % mod;
            }

            hash[0] = 0;
            for(int i=0; i<n; i++){
                hash[i+1] = (hash[i] * base + s.charAt(i)) % mod;
            }

        }

        long get(int l, int r){
            long h = hash[r+1] - hash[l] * power[r-l+1] % mod;
            return (h+mod)%mod;
        }

        long getK(int l){
            long h = hash[l+k] - hash[l] * power[k] % mod;
            return (h+mod)%mod;
        }
    }
    
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int total = (int) Math.pow(2,k);

        if( (n-k+1) < total ) return false;

        HashSet<Long> set = new HashSet<>();
        int codes = 0;

        RollingHash r = new RollingHash(s, 31, 1_000_000_007, k);
        for(int i=0; i<n-k+1; i++){
            long code = r.getK(i);
            if( !set.contains(code) ){
                codes++;
                set.add(code);
            }
        }

        return codes==total ? true : false;
    }
}