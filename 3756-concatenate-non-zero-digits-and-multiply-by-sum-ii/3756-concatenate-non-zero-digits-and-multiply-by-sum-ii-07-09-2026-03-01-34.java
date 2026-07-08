class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int mod = 1000000007;

        // Using 1-based indexing for prefix arrays to easily handle l-1 bounds
        long[] pow10 = new long[n + 1];
        long[] P = new long[n + 1];
        long[] prefSum = new long[n + 1];
        int[] cnt = new int[n + 1];

        // Precompute powers of 10 modulo 10^9+7
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        // Build prefix arrays
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            
            prefSum[i + 1] = prefSum[i] + d;
            cnt[i + 1] = cnt[i];
            P[i + 1] = P[i];

            if (d != 0) {
                cnt[i + 1]++;
                P[i + 1] = (P[i] * 10 + d) % mod;
            }
        }

        int m = queries.length;
        int[] ans = new int[m];

        // Process each query
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // 1-based array mapping: l becomes l, r becomes r+1
            long sum = prefSum[r + 1] - prefSum[l];
            int count = cnt[r + 1] - cnt[l];

            // Extract the concatenated substring value
            // Add 'mod' before the final modulo to handle negative results in Java
            long val = (P[r + 1] - (P[l] * pow10[count]) % mod + mod) % mod;

            ans[i] = (int) ((val * (sum % mod)) % mod);
        }

        return ans;
    }
}
