class Solution {
    int[][] dir = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<8 && y<8;
    }
    public boolean canReach(int[] start, int[] target) {
        int destX = target[0], destY = target[1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[8][8];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int move = curr[2];

            for(int[] d: dir){
                int X = x+d[0];
                int Y = y+d[1];

                if(isValid(X, Y) && !visited[X][Y]){
                    if(X == destX && Y == destY && (move+1)%2 == 0) return true;

                    q.offer(new int[]{X,Y, move+1});
                    visited[X][Y] = true;
                }
            }
        }
        return false;
    }
}