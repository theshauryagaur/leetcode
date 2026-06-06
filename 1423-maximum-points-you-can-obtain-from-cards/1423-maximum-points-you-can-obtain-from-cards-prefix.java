class Solution {
    public int maxScore(int[] pts, int k) {
        int n = pts.length;
        
        int remCards = n-k;
        int sumRemCards = 0;
        for(int i=0; i<remCards; i++){
            sumRemCards += pts[i];
        }

        int total = sumRemCards;

        int minSumRemCards = sumRemCards;

        for(int i=remCards; i < n ; i++){
            total += pts[i];
            sumRemCards += pts[i]-pts[i-remCards];
            minSumRemCards = Math.min(minSumRemCards, sumRemCards);

        }

        return total - minSumRemCards;
    }
}