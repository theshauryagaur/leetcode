class Solution {
    int m, n;
    int[][] dir = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

    public long help(int[][] grid, boolean[][] visi, int i, int j){
        Queue<int[]> q = new ArrayDeque<>();

        long sum = grid[i][j];

        q.add(new int[]{i, j});
        visi[i][j] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int x = curr[0], y = curr[1];
            for(int[] d: dir){
                int a = x + d[0], b = y + d[1];
                if(a>=0 && a<m && b>=0 && b<n && grid[a][b] != 0 && !visi[a][b]){
                    sum += grid[a][b];
                    q.add(new int[]{a, b});
                    visi[a][b] = true;
                }
            }
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int ans = 0;

        boolean[][] visi = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0 && !visi[i][j]){
                    if( help(grid, visi, i, j)%k == 0 ) ans++;
                }
            }
        }

        return ans;
    }
}