class Solution {
    public long minEnergy(int n, int brightness, int[][] intv) {
        int m = intv.length;

        Arrays.sort(intv, (a,b)-> {
            if(a[0]==b[0]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        long len = 0;
        int[] merge = new int[2];
        merge = intv[0];

        int j=1;
        while(j < m){
            if(intv[j][0] <= merge[1]){
                if(merge[1] <= intv[j][1]){
                    merge[1] = intv[j][1];
                }
            }
            else{
                len += (merge[1]-merge[0]+1);
                merge = intv[j];
            }
            j++;
        }

        len +=  (merge[1]-merge[0]+1) ;
        System.out.print(len);

        return len * (int) (Math.ceil( brightness/3.0));
    }
}