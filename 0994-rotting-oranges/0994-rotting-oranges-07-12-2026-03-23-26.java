class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    int m;
    int n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n =grid[0].length;
        Queue<int[]> multiSrc = new ArrayDeque<>();

        int nonRotten = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    multiSrc.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    nonRotten++;
                }

            }
        }

        int time = 0;

        while(!multiSrc.isEmpty()){
            int size=multiSrc.size();

            int nonRottenBefore = nonRotten;

            while(size-- > 0){
                int[] curr = multiSrc.poll();
                for(int[] d: dir){
                    int x = curr[0]+d[0];
                    int y = curr[1]+d[1];

                    if(isValidCell(x,y) && grid[x][y] == 1){
                        multiSrc.offer(new int[]{x,y});

                        grid[x][y] = 2;
                        nonRotten--;
                    }
                }
            }

            if(nonRottenBefore > nonRotten) time++;
        }

        return nonRotten > 0 ? -1 : time;
    }

    public boolean isValidCell(int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
}