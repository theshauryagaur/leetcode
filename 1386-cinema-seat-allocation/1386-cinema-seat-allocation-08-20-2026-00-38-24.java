class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        Arrays.sort(rs, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int ans = 0;
        int reserRow = 0;
        int l = 0, r = 0;

        boolean[] seat = new boolean[11];

        while(r < rs.length){
            
            if(rs[r][0] != rs[l][0]){
                reserRow++;

                ans += calculateFamilies(seat);

                seat = new boolean[11];
                seat[rs[r][1]] = true;
                l = r;
            }
            else{
                seat[rs[r][1]] = true;
                r++;
            }
        }
        
        reserRow++;
        ans += calculateFamilies(seat);

        ans += (n-reserRow)*2;
        return ans;
    }
    private int calculateFamilies(boolean[] seat) {
        boolean leftFree = !seat[2] && !seat[3] && !seat[4] && !seat[5];
        boolean rightFree = !seat[6] && !seat[7] && !seat[8] && !seat[9];
        boolean middleFree = !seat[4] && !seat[5] && !seat[6] && !seat[7];

        if (leftFree && rightFree) {
            return 2;
        } else if (leftFree || rightFree || middleFree) {
            return 1;
        }
        return 0;
    }
}