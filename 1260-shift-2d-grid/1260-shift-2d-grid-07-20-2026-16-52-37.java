class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        k %= (m*n);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                list.add(grid[i][j]);
            }
        }

        int st = 0, end = m*n - k - 1; 
        while(st < end){
            int temp = list.get(st);
            list.set(st, list.get(end));
            list.set(end, temp);

            st++; 
            end--;
        }

        st = m*n - k; end = m*n - 1;
        while(st < end){
            int temp = list.get(st);
            list.set(st, list.get(end));
            list.set(end, temp);

            st++;
            end--;
        }

        st = 0; end = m*n - 1;
        while(st < end){
            int temp = list.get(st);
            list.set(st, list.get(end));
            list.set(end, temp);

            st++;
            end--;
        }
        
        //System.out.print(list);
        
        int ind = 0;
        for(int i=0; i<m; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<n; j++){
                row.add(list.get(ind++));
            }
            ans.add(row);
        }


        return ans;
    }
}