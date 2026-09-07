class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();

        long[] dp = new long[n+1];
        int[] ind = new int[26];
        long MOD = (long) (1e9+7);
        Arrays.fill(ind, -1);

        for(int i=0; i<n; i++){
            int x = s.charAt(i)-'a';
            if(ind[x] == -1){
                dp[i+1] = (dp[i]*2 + 1)%MOD;

            }else{
                int lastInd = ind[x];
                dp[i+1] = (dp[i]*2 + MOD - dp[lastInd])%MOD;
            }
            ind[x] = i;
        }
        return (int) dp[n];
    }
}