class Solution {
    public int[] findDegrees(int[][] mat) {
        int[] deg = new int[mat.length];

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                if(mat[i][j] == 1) {
                    deg[i]++;
                }
            }
        }
        return deg;
    }
}