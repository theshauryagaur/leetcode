class Solution {
    int[][] paths;
    public boolean isValid(int m, int n, int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
    public int uniquePaths(int m, int n) {
        paths = new int[m+1][n+1];
        paths[0][1] = 1;
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