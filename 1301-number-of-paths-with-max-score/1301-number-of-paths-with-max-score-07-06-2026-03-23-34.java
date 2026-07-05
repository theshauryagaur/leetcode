class Solution {
    int[][] dp;
    long[][] ways;
    int n;
    int mod = 1_000_000_007;
    // public boolean helper(int[][] grid, int i, int j, int pathSum){
    //     if(i<0 || j<0) return false;
    //     if(i == 0 && j == 0) return true;

    //     // if(grid)

    //     if(grid[i][j] == -1) return Integer.MIN_VALUE;

    //     pathSum += grid[i][j];

    //     boolean up = helper(grid, i-1, j, pathSum, steps+1);
    //     boolean left = helper(grid, i, j-1, pathSum, steps+1);
    //     boolean diag = helper(grid, i-1, j-1, pathSum, steps+1);

    //     dp[i][j] = Math.max(up, Math.max(left, diag));

    //     return dp[i][j];

    // }
    public int[] help(int i, int j){
        if(i >= n || j >= n) return new int[]{-1, 0};

        return new int[]{dp[i][j],(int) ways[i][j]};
    }
    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        ways = new long[n][n];
        
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++){
            String s = board.get(i);
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if(c == 'E' || c == 'S') grid[i][j] = 0;
                else if(c == 'X') grid[i][j] = -1;
                else grid[i][j] = c-'0';
            }
        }
        dp[n-1][n-1] = 0;
        ways[n-1][n-1] = 1;

        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == n-1 && j == n-1) continue;
                if(grid[i][j] == -1) continue;

                int[] right = help(i, j+1);
                int[] down = help(i+1, j);
                int[] diag = help(i+1, j+1);

                int prev = Math.max(right[0], Math.max(down[0], diag[0]));
                // if(prev == Integer.MIN_VALUE) dp[i][j] = grid[i][j];
                // else dp[i][j] += grid[i][j] + prev;
                if(prev != -1){
                    dp[i][j] = grid[i][j] + prev;
                    if(prev == right[0]) ways[i][j] = (ways[i][j] + right[1]) % mod;
                    if(prev == down[0]) ways[i][j] = (ways[i][j] + down[1]) % mod;
                    if(prev == diag[0]) ways[i][j] = (ways[i][j] + diag[1]) % mod;
                } 
                // else{
                //     dp[i][j] = Integer.MIN_VALUE;
                //     ways[i][j] = 0;
                // }
            }
        }

        if(dp[0][0] == -1) return new int[]{0,0};
        return new int[]{dp[0][0],(int) ways[0][0]};
    }
}