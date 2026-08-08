class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,-1,1};
        int m = maze.length;
        int n = maze[0].length;
        int sRow = entrance[0];
        int sCol = entrance[1];

        Queue<int[]> q = new ArrayDeque<>();
        int[][] step = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(step[i], -1);
        }
        step[sRow][sCol] = 0;
        q.offer(new int[]{sRow,sCol});

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                int currSteps = step[row][col];

                for(int i=0; i<4; i++){
                    int x = row+dx[i];
                    int y = col+dy[i];
                    if(x >= 0 && y >= 0 && x < m && y < n){
                        if(maze[x][y] == '.'){
                            if((x == 0 || y == 0 || x == m-1 || y == n-1) && step[x][y] != 0) return currSteps + 1;

                            if(step[x][y] == -1){
                                step[x][y] = currSteps+1;
                                q.offer(new int[]{x,y});
                            }
                        }
                    }

                }
            }
        }

        return -1;
    }
}