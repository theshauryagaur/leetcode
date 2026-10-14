class Solution {
    int[][] rowPre;
    int[][] colPre;
    int m, n;
    public void helper(char[][] mat){
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                if(j==n-1){
                    rowPre[i][j] = mat[i][j] == '0' ? 0 : 1;
                }
                else{
                    rowPre[i][j] += mat[i][j] == '0' ? 0 : rowPre[i][j+1]+1;
                }
            }
        }
        
        for(int j=n-1; j>=0; j--){
            for(int i=m-1; i>=0; i--){
                if(i==m-1){
                    colPre[i][j] = mat[i][j] == '0' ? 0 : 1;
                }
                else{
                    colPre[i][j] += mat[i][j] == '0' ? 0 : colPre[i+1][j]+1;
                }
            }
        }
        return;
    }

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
                        int down = colPre[i][j];
                        int right = rowPre[i][j];

                        int min = Math.min(down, right);

                        if(min >= 2 && mat[i+1][j+1] == '1'){
                            sq[i][j] = Math.min(1 + sq[i+1][j+1], min);
                        }
                        else sq[i][j] = 1;
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
        rowPre = new int[m][n];
        colPre = new int[m][n];

        helper(matrix);
        // System.out.println(Arrays.deepToString(rowPre));
        // System.out.println(Arrays.deepToString(colPre));
        return maxSq(matrix);
    }
}