class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        Set<Integer> pts = new HashSet<>();
        for(int i=0; i<m; i++){
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    sum ++;
                    set.add(i*1000 + j);
                }
            }          
            if(sum == 1) continue;
            ans += sum;
            pts.addAll(set);
        }

        for(int j=0; j<n; j++){
            int sum = 0;
            int added = 0;

            Set<Integer> set = new HashSet<>();
            for(int i=0; i<m; i++){
                if(grid[i][j] == 1){
                    sum ++;
                    if(pts.contains(i*1000 + j)) added++;
                    set.add(i*1000 + j);
                }
            }          
            if(sum == 1) continue;
            ans += sum - added; 

            pts.addAll(set);
        }
        return ans;
    }
}