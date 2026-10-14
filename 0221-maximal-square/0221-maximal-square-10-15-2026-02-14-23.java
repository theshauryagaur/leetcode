class Solution {
    int m, n;
    public int maxSq(char[][] mat){
        int[][] sq = new int[m][n];
        int ans = 0;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == m-1 || j == n-1){
                    sq[i][j] = mat[i][j] == '0' ? 0 : 1;
                }
                else{
                    if(mat[i][j] == '1'){
                        int min = Math.min(sq[i+1][j], sq[i][j+1]);

                        sq[i][j] = 1 + Math.min(sq[i+1][j+1], min);
                    }
                }
                ans = Math.max(ans, sq[i][j]);
            }
        }
        return ans*ans;
    }
    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        return maxSq(matrix);
    }
}