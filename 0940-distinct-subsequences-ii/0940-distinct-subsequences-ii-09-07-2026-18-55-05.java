class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();

        int[] dp = new int[n+1];
        int[] ind = new int[26];
        int MOD = (int) (1e9+7);
        Arrays.fill(ind, -1);

        for(int i=0; i<n; i++){
            int x = s.charAt(i)-'a';

            int lastInd = ind[x];
            if(lastInd == -1){ // char appearing for the first time
                dp[i+1] = dp[i]*2 + 1; // __*2 because we have two choices either to add the curr char to all previous subseq or not to and +1 for the only subseq of curr char
                if(dp[i+1] > MOD) dp[i+1] -= MOD; 
            }else{
                dp[i+1] = dp[i]*2 - dp[lastInd]; // delete the repetions 
                
                if(dp[i+1] > MOD) dp[i+1] -= MOD; 
                if(dp[i+1] < 0) dp[i+1] += MOD; 
            }
            ind[x] = i;
        }
        return dp[n];
    }
}