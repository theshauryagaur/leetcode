class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int ans = 0;
        int curr = prices[0];

        for(int i=1; i<n; i++){
            if(prices[i] > curr){
                ans += prices[i] - curr;
            }
            curr = prices[i];
        }
        return ans;
    }
}