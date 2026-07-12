class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int m;
    int n;

    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }

    public void dfs(char[][] board, boolean[][] visited,int i,int j, int[] d){
        int x = i+d[0];
        int y = j+d[1];

        while(isValid(x, y) && board[x][y] == 'X'){
            visited[x][y] = true;
            x += d[0];
            y += d[1];
        }

        x = i-d[0];
        y = j-d[1];
        while(isValid(x, y) && board[x][y] == 'X'){
            visited[x][y] = true;
            x -= d[0];
            y -= d[1];
        }
    }
    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        int ships = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    visited[i][j] = true;

                    for(int[] d: dir){
                        int x = i+d[0];
                        int y = j+d[1];

                        if(isValid(x, y) && board[x][y] == 'X'){
                            dfs(board, visited, i, j, d);
                        }

                    }

                    ships ++;

                }
            }
        }
        return ships;
    }
}