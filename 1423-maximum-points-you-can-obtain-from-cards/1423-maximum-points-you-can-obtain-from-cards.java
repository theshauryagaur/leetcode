class Solution {
    public int maxScore(int[] pts, int k) {
        int n = pts.length;
        int[] prefix = new int[n+1];

        prefix[0] = 0;
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + pts[i];
        }

        int total = prefix[n];

        if(k == n) return total;

        int remCards = n-k;
        int sumRemCards = Integer.MAX_VALUE;

        for(int i=0; i < n-remCards+1 ; i++){
            sumRemCards = Math.min(sumRemCards, prefix[i+remCards] - prefix[i]);
        }

        return total - sumRemCards;
    }
}