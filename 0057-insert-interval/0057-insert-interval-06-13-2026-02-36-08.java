class Solution {
    public int[][] insert(int[][] intervals, int[] query) {
        if(intervals.length == 0) return new int[][]{query};

        int found = -1;
        int i=0, j=0;
        List<int[]> list = new ArrayList<>();
        while(found == -1 && i<intervals.length){
            int[] intv = intervals[i];
            if(query[0] <= intv[1]){
                if(query[1] >= intv[0]){
                    query[0] = Math.min(query[0], intv[0]);
                    query[1] = Math.max(query[1], intv[1]);
                }
                else{
                    // list.add(query);
                    found = 1;
                    break;
                }
                found = 1;
            }
            else list.add(intv);
            i++;
        }
         
        if(found == 1){
            while( i < intervals.length && query[1] >= intervals[i][0]) {
                query[1] = Math.max(query[1], intervals[i][1]);
                i++;
            }
            list.add(query);

            while(i < intervals.length){
                list.add(intervals[i++]);
            }
        }
        else {
            list.add(query);
        }

        int[][] ans = new int[list.size()][];
        for(int k=0; k<list.size(); k++) ans[k] = list.get(k);

        return ans;
    }
}