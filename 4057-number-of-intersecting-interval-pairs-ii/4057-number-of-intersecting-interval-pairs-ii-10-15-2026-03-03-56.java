class Solution {
    int n;
    public int binSea(int[][] intv, int i){
        int st = intv[i][0], end = intv[i][1];

        int l = i, r = n-1;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(intv[mid][0] <= end){
                l = mid+1;
            }
            else r = mid-1;
        }
        return r;
    }
    public long countIntersectingIntervals(int[][] intv) {
        n = intv.length;

        long ans = 0;

        Arrays.sort(intv, (a,b) -> {
            if(a[0] != b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        });

        // System.out.println(Arrays.deepToString(intv));

        for(int i=0; i<n-1; i++){
            int ind = binSea(intv, i);
            ans += ind - i;
        }
        return ans;
    }
}