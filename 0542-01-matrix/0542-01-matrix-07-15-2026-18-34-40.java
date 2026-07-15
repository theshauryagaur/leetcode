class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> multiSrc = new ArrayDeque<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    multiSrc.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int dist = 1;
        while(!multiSrc.isEmpty()){

            int size = multiSrc.size();
            while(size-->0){

                int[] curr = multiSrc.poll();

                for(int[] d : dir){
                    int x = curr[0]+d[0];
                    int y = curr[1]+d[1];

                    if(x<0 || y<0 || x>=m || y>=n) continue;

                    if(!visited[x][y]){
                        multiSrc.offer(new int[]{x, y});
                        visited[x][y] = true;
                        ans[x][y] = dist;
                    }
                }
            }
            dist++;
        }

        return ans;
    }
}