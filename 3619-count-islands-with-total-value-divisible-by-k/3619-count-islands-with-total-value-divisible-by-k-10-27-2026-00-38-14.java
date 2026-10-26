class Solution {
    int m, n;

    public long dfs(int[][] grid, int a, int b){
        if(!(a>=0 && a<m && b>=0 && b<n) || grid[a][b] == 0) return 0;

        long sum = grid[a][b];
        grid[a][b] = 0;

        sum += dfs(grid, a+1, b);
        sum += dfs(grid, a-1, b);
        sum += dfs(grid, a, b+1);
        sum += dfs(grid, a, b-1);

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
                    if( dfs(grid, i, j)%k == 0 ) ans++;
                }
            }
        }

        return ans;
    }
}