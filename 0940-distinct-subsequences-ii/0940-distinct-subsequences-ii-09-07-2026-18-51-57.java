class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();

        int[] dp = new int[n+1];
        int[] ind = new int[26];
        int MOD = (int) (1e9+7);
        Arrays.fill(ind, -1);

        for(int i=0; i<n; i++){
            int x = s.charAt(i)-'a';
            
            if(ind[x] == -1){
                dp[i+1] = dp[i]*2 + 1;
                if(dp[i+1] > MOD) dp[i+1] -= MOD; 
            }else{
                int lastInd = ind[x];
                dp[i+1] = dp[i]*2 - dp[lastInd];
                
                if(dp[i+1] > MOD) dp[i+1] -= MOD; 
                if(dp[i+1] < 0) dp[i+1] += MOD; 
            }
            ind[x] = i;
        }
        return dp[n];
    }
}