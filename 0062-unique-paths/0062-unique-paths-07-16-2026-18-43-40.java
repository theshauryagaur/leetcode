class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m+1][n+1];
        paths[1][0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){

                int top = paths[i-1][j];
                int left = paths[i][j-1];

                paths[i][j] = top+left;
            }
        }
        //System.out.println(Arrays.deepToString(paths));
        return paths[m][n];
    }
}