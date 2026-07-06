class Solution {
    public int removeCoveredIntervals(int[][] intv) {
        int n = intv.length;
        if(n == 1) return 1;

        //List<Integer> ind = new ArrayList<>();
        Arrays.sort(intv, (a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            else return Integer.compare(b[1], a[1]);
        });

        //System.out.println(Arrays.deepToString(intv));
        
        int rem = 0;
        int i=0, j=1;
        int k = 0; // partial overlap;
        while(i < n && j < n){
            int[] curr = intv[i];
            int[] next = intv[j];

            if(curr[0] <= next[0]){
                if(next[1] <= curr[1]){
                    j++;
                    rem++;
                }   // skip (covered)
                else {
                    i = j; // update to curr widest
                    j = i+1; 
                }

            }
            else {
                j++;

            }
        }
        return n - rem;
    }
}