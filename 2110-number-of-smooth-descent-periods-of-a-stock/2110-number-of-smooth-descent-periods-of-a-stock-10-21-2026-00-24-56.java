class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;

        long ans = 0;
        int currLen = 0;

        for(int i=0; i<n; i++){
            if(i < n-1){
                if(prices[i] - prices[i+1] == 1){
                    currLen++;
                    ans += currLen;
                }
                else{
                    ans += currLen+1;
                    currLen = 0;
                }
            }
            else ans+=currLen+1;
        }
        return ans;
    }
}