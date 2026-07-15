class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int INF = Integer.MAX_VALUE;

        int[][] ans = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    continue;
                }
                int left = INF, top = INF;
                if(i >= 1) top = ans[i-1][j];
                if(j >= 1) left = ans[i][j-1];
                
                if(top != INF || left != INF) ans[i][j] = Math.min(left, top)+1;
                else ans[i][j] = INF;
            }
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(mat[i][j] == 0){
                    continue;
                }
                int right = INF, bottom = INF;
                if(i < m-1) bottom = ans[i+1][j];
                if(j < n-1) right = ans[i][j+1];
                
                if(bottom != INF || right != INF) ans[i][j] = Math.min(ans[i][j], Math.min(bottom,right)+1);
                
            }
        }

        return ans;
    }
}