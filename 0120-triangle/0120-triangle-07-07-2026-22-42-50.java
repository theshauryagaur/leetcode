class Solution {
    int n;
    List<int[]> dp;
    public int helper(List<List<Integer>> grid, int i, int j){
        if(i >= n) return 0;

        if(dp.get(i)[j] != 4000000) return dp.get(i)[j];

        int left = helper(grid, i+1, j);
        int right = helper(grid, i+1, j+1);

        dp.get(i)[j] = grid.get(i).get(j) + Math.min(left, right);

        return dp.get(i)[j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        dp = new ArrayList<>();
        for(int i=0; i<n; i++){
            dp.add(new int[i+1]);
            Arrays.fill(dp.get(i), 4000000);
        }
        return helper(triangle, 0, 0);
    }
}