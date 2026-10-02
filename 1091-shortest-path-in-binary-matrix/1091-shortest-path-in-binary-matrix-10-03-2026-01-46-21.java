class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] cost = new int[n][n];
        // int[][] dir = {{1,1},{1,0},{0,1},{0,-1},{-1,0},{-1,-1},{-1,1},{}};
        int[][] dir = {
            {0, -1},  // 0: North
            {1, -1},  // 1: North-East
            {1, 0},   // 2: East
            {1, 1},   // 3: South-East
            {0, 1},   // 4: South
            {-1, 1},  // 5: South-West
            {-1, 0},  // 6: West
            {-1, -1}
        };  // 7: North-West;

        for(int i=0; i<n; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        cost[0][0] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int x = curr[0], y = curr[1];
            int costU = cost[x][y];

            for(int[] d: dir){
                int a = x+d[0], b = y+d[1];
                if(a>=0 && a<n && b>=0 && b<n && grid[a][b] == 0){
                    if(cost[a][b] > costU + 1){
                        q.offer(new int[]{a,b});
                        cost[a][b] = costU + 1;
                        grid[a][b] = 1;
                    }
                    if(a == n-1 && b == n-1) break;
                }
            }
        }
        return cost[n-1][n-1] == Integer.MAX_VALUE ? -1 : cost[n-1][n-1];
    }
}