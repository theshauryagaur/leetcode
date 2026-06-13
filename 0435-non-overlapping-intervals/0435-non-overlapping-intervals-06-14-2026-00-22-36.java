class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        // System.out.println(Arrays.deepToString(intervals));

        int n = intervals.length;
        int cnt = 0; // max no of intervals we can take
        int i=0;
        int lastEndTime = -50000;
        while(i < n){
            int[] intv = intervals[i++];
            if(intv[0] >= lastEndTime){
                cnt ++;
                lastEndTime = intv[1];
            }
        }

        return n-cnt;
    }
}