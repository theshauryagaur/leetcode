class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n = series1.length;
        int m = series2.length;
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0, j=0;
        while(i<n && j<m){
            List<Integer> series = new ArrayList<>();
            int ts1 = series1[i][0];
            int ts2 = series2[j][0];
            if(ts1 == ts2){
                series.add(ts1);
                series.add(series1[i][1] + series2[j][1]);
                i++;
                j++;
            }
            else if(ts1 < ts2){
                series.add(ts1);
                series.add(series1[i][1] + series2[j][1]);
                i++;
            }
            else{ // (ts1 > ts2)
                series.add(ts2);
                series.add(series1[i][1] + series2[j][1]);
                j++;
            }
            ans.add(series);
        }
        while(i<n){
            ans.add(new ArrayList<>(List.of(series1[i][0], series1[i][1])));
            i++;
        }
        while(j<m){
            ans.add(new ArrayList<>(List.of(series2[j][0], series2[j][1])));
            j++;
        }
        return ans;
    }
}