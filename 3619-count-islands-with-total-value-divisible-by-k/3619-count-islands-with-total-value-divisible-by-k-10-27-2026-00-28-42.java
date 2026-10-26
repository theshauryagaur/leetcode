class Solution {
    int m, n;
    int[][] dir = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

    public long help(int[][] grid, int i, int j){
        Queue<int[]> q = new ArrayDeque<>();

        long sum = grid[i][j];

        q.add(new int[]{i, j});
        grid[i][j] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int x = curr[0], y = curr[1];
            for(int[] d: dir){
                int a = x + d[0], b = y + d[1];
                if(a>=0 && a<m && b>=0 && b<n && grid[a][b] != 0){
                    sum += grid[a][b];
                    q.add(new int[]{a, b});
                    grid[a][b] = 0;
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
                if(grid[i][j] != 0){
                    if( help(grid, i, j)%k == 0 ) ans++;
                }
            }
        }

        return ans;
    }
}