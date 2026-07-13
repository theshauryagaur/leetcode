class Solution {
    int m;
    int n;
    int[][] minTime;

    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int INT_MIN = Integer.MIN_VALUE;

    public boolean isValidCell(int x, int y){
        return x>=0 && y>=0 && x<m && y<n;
    }

    public boolean possi(int[][] grid, int time){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,time+1});

        boolean[][] visi = new boolean[m][n];
        visi[0][0] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] d: dir){
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];
                int currTime = curr[2];
                //System.out.println(x+" "+y+" "+currTime);

                if(isValidCell(x,y) && !visi[x][y]){
                    if(minTime[x][y] >= currTime && x==m-1 && y==n-1) return true;

                    if(minTime[x][y] > currTime){
                        q.add(new int[]{x, y, currTime+1});
                    }
                    visi[x][y] = true;
                }
            }
        }
        return false;
    }

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        minTime = new int[m][n];
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> multiSrc = new ArrayDeque<>();

        int wall=0;
        int fire=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    multiSrc.offer(new int[]{i,j});
                    fire++;
                    minTime[i][j] = 0;
                    
                }
                else if(grid[i][j] == 2) {
                    wall++;
                    minTime[i][j] = INT_MIN;
                }
            }
        }

        int grass = m*n - wall - fire;
        int affected = 0;

        int time = 1;
        boolean[][] visi = new boolean[m][n];

        while(!multiSrc.isEmpty()){
            int size = multiSrc.size();

            while(size-- > 0){
                int[] curr = multiSrc.poll();

                for(int[] d: dir){
                    int x = curr[0]+d[0];
                    int y = curr[1]+d[1];

                    if(isValidCell(x,y) && !visi[x][y] && grid[x][y] == 0){
                        visi[x][y] = true;
                        multiSrc.add(new int[]{x, y});

                        minTime[x][y] = time;

                        affected++;
                    }
                    
                }
            }
            time++;
        }
        System.out.println(grass+" "+affected+" "+time);

        int low = 0;
        int high = 1000000000;
        int ans = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(possi(grid, mid)){
                low = mid+1;
                ans = mid;
            }
            else high = mid-1;
        }

        return ans;
    }
}