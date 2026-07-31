class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int LOG = 18;

        Integer[] wt = new Integer[n];
        for(int i=0; i<n; i++) wt[i]=i;

        Arrays.sort(wt, (a,b) -> Integer.compare(nums[a],nums[b]));

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[wt[i]] = i;

        int[][] up = new int[n][LOG];

        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r < i) r = i;
            while (r + 1 < n && nums[wt[r + 1]] - nums[wt[i]] <= maxDiff) r++;
            up[i][0] = r;
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int a = pos[queries[i][0]];
            int b = pos[queries[i][1]];
            if (a > b) { int t = a; a = b; b = t; }

            if (a == b) {
                ans[i] = 0;
                continue;
            }

            int curr = a, steps = 0;
            for (int j = LOG - 1; j >= 0; j--) {
                if (up[curr][j] < b) {
                    curr = up[curr][j];
                    steps += (1 << j);
                }
            }

            ans[i] = (up[curr][0] >= b) ? steps + 1 : -1;
        }

        return ans;
    }
}