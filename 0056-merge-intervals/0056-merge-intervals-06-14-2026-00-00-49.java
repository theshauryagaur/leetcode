class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<List<Integer>> ans = new ArrayList<>();
        int i=0, j=1;
     
        while(j<intervals.length){
            if(intervals[j][0] <= intervals[i][1]){             
                intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
                j++;
        
            }
            else {
                ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
                i=j;
                j++;
            }
        }
        //add last interval
        ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));

        int n=ans.size();
        int[][] result = new int[n][2];
        for(i=0; i<n; i++){
            result[i][0] =  ans.get(i).get(0);
            result[i][1] =  ans.get(i).get(1);
        }
        return result;
    }
}