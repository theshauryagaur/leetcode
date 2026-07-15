class Solution {
    int m;
    int n;
    boolean[][] visited;

    int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<m && y<n;
    }

    public void helper(char[][] board, int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] d : dir){
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];

                if(isValid(x,y) && !visited[x][y] && board[x][y] == 'O'){
                    q.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];
        
        for(int j=0; j<n; j++){

            if(!visited[0][j] && board[0][j] == 'O'){
                helper(board, 0, j);
            }

            if(!visited[m-1][j] && board[m-1][j] == 'O'){
                helper(board, m-1, j);
            }
        }
        for(int i=0; i<m; i++){

            if(!visited[i][0] && board[i][0] == 'O'){
                helper(board, i, 0);
            }

            if(!visited[i][n-1] && board[i][n-1] == 'O'){
                helper(board, i, n-1);
            }
        }



        for(int i=0; i<m; i++){
            if(i == 0 || i == m-1) continue;
            for(int j=0; j<n; j++){
                if(j == 0 || j == n-1) continue;
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}