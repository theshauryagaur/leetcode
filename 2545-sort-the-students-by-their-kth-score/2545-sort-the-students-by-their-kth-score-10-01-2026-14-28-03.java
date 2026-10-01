class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length;
        int n = score[0].length;

        int[][] ans = new int[m][n];

        Integer[] ind = new Integer[m];
        for(int i=0; i<m; i++){
            ind[i] = i;
        }

        Arrays.sort(ind, (a,b) -> {
            return score[b][k] - score[a][k];
        });

        for(int i=0; i<m; i++){
            int indK = ind[i];
            for(int j=0; j<n; j++){
                ans[i][j] = score[indK][j];
            }
        }
        return ans;
    }
}