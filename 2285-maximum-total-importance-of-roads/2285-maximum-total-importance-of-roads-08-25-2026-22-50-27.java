class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];

        for(int[] road: roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }

        long ans = 0;
        long x = n;
        Arrays.sort(degree);
        for(int i=n-1; i>=0; i--){
            ans += x*degree[i];
            x--;
        }
        return ans;
    }
}