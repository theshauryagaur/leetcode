class Solution {
    long[][][] cost;
    int[][] wait;
    int row, col;

    public long helper(int i, int j, int move){
        if(i == row-1 && j == col-1) return 0;
        if(i>=row || j>=col) return (long) 1e12;

        if(cost[i][j][move] != -1) return cost[i][j][move];
        
        long right = Long.MAX_VALUE;
        long down = Long.MAX_VALUE;
        long waiting = Long.MAX_VALUE;

        if(move == 0){
            right = (i+1)*(j+2) + helper(i, j+1, move^1);
            down = (i+2)*(j+1) + helper(i+1, j, move^1);
        }
        else{
            waiting = wait[i][j] + helper(i, j, move^1);
        }

        cost[i][j][move] = Math.min(waiting, Math.min(down, right));
        
        return cost[i][j][move];
    }

    public long minCost(int m, int n, int[][] waitCost) {
        row = m;
        col = n;

        cost = new long[m][n][2];
        wait = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                cost[i][j][0] = -1;
                cost[i][j][1] = -1;

                wait[i][j] = waitCost[i][j];
            }
        }

        return 1 + helper(0,0,0);
    }
}