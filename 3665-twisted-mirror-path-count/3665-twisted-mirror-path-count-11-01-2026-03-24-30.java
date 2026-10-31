class Solution {
    int m, n;
    int[][][] memo;
    int[][] grid;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        // memo[r][c][dir] will store the final 1D landing coordinate 
        // initialized to -2 since -1 will represent "out of bounds"
        memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }

        int MOD = 1_000_000_007;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // Traverse the grid and push paths forward
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                // 1. Try moving Right (dir = 0)
                int rightTarget = getLanding(i, j + 1, 0);
                if (rightTarget != -1) {
                    int r = rightTarget / n;
                    int c = rightTarget % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }

                // 2. Try moving Down (dir = 1)
                int downTarget = getLanding(i + 1, j, 1);
                if (downTarget != -1) {
                    int r = downTarget / n;
                    int c = downTarget % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    // dir: 0 means we entered the cell moving Right, 1 means moving Down
    private int getLanding(int r, int c, int dir) {
        // Base case: Out of bounds
        if (r >= m || c >= n) return -1;
        
        // Return if already computed
        if (memo[r][c][dir] != -2) return memo[r][c][dir];

        if (grid[r][c] == 0) {
            // Valid empty space, stop here and return 1D coordinate
            memo[r][c][dir] = r * n + c;
        } else {
            // Hit a mirror, reflect immediately based on incoming direction
            if (dir == 0) {
                // Entering Right -> Turns Down
                memo[r][c][dir] = getLanding(r + 1, c, 1);
            } else {
                // Entering Down -> Turns Right
                memo[r][c][dir] = getLanding(r, c + 1, 0);
            }
        }
        
        return memo[r][c][dir];
    }
}