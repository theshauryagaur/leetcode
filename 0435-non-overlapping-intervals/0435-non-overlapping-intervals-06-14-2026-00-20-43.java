class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]); // Sort by 2nd element
            }
            return Integer.compare(o1[0], o2[0]); // Tie-breaker: 1st element
        });

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