class Solution {
    int m;
    int n;
    boolean[][] visited;
    int[][] ans;

    int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<m && y<n;
    }

    // public void helper(int[][] mat, int i, int j){
    //     Queue<int[]> q = new ArrayDeque<>();
    //     q.offer(new int[]{i,j});

    //     while(!q.isEmpty()){
    //         int[] curr = q.poll();

    //         for(int[] d : dir){
    //             int x = curr[0]+d[0];
    //             int y = curr[1]+d[1];
    //             int d = curr[2];

    //             if(isValid(x,y) && !visited[x][y] && mat[x][y] == 1){
    //                 q.offer(new int[]{x,y,d+1});
    //                 visited[x][y] = true;
    //                 ans[x][y] = d;
    //             }
    //         }
    //     }
    // }

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        ans = new int[m][n];
        visited = new boolean[m][n];

        Queue<int[]> multiSrc = new ArrayDeque<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    //ans[i][j] = 0;
                    multiSrc.offer(new int[]{i,j,0});
                }
            }
        }

        while(!multiSrc.isEmpty()){
            int[] curr = multiSrc.poll();

            for(int[] d : dir){
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];
                int dist = curr[2]+1;

                if(isValid(x,y) && !visited[x][y] && mat[x][y] == 1){
                    multiSrc.offer(new int[]{x, y, dist});
                    visited[x][y] = true;
                    ans[x][y] = dist;
                }
            }
        }

        return ans;
    }
}