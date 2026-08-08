class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,-1,1};
        int m = maze.length;
        int n = maze[0].length;
        int sRow = entrance[0];
        int sCol = entrance[1];

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visi = new boolean[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(visi[i], false);
        }
        visi[sRow][sCol] = true;
        q.offer(new int[]{sRow,sCol});

        int move = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int i=0; i<4; i++){
                    int x = row+dx[i];
                    int y = col+dy[i];
                    if(x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == '.'){
                        if((x == 0 || y == 0 || x == m-1 || y == n-1) && visi[x][y] != true) return move + 1;

                        if(!visi[x][y]){
                            visi[x][y] = true;
                            q.offer(new int[]{x,y});
                        }
                    }
                }
            }
            move++;
        }

        return -1;
    }
}