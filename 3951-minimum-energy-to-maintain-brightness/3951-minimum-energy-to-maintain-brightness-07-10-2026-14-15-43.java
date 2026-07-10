class Solution {
    public long minEnergy(int n, int brightness, int[][] intv) {
        int m = intv.length;

        Arrays.sort(intv, (a,b) -> a[0]-b[0]);

        long len = 0;
        int[] merge = new int[2];
        merge = intv[0];

        int j=1;
        while(j < m){
            int[] curr = intv[j];
            if(curr[0] <= merge[1]){
                merge[1] = Math.max(merge[1], curr[1]);
            }
            else{
                len += (merge[1]-merge[0]+1);
                merge = curr;
            }
            j++;
        }

        len +=  (merge[1]-merge[0]+1) ;

        
        return len * ((brightness + 3 - 1)/3);
    }
}