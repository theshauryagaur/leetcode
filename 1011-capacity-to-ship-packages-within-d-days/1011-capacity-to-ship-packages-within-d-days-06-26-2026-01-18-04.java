class Solution {
    public boolean isValid(int[] weights, int currCapa, int days){
        int currDays=1;
        int currWeight = 0; 
        for(int i=0;i<weights. length;i++){
            if(currWeight + weights[i] > currCapa) {
                currDays++;
                currWeight = weights[i];
            }else currWeight += weights[i];
            if(currDays > days) break;
        }
        return currDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int ans=-1;
        int max = Integer.MIN_VALUE;
        int maxCapa = 0;

        for(int i:weights){
            if(i>max) max=i;
            maxCapa += i;
        }
        int minCapa = max;


        if(days == 1) return maxCapa;
        if(days == n) return minCapa;

        int st=minCapa, end=maxCapa;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isValid(weights, mid, days)){
                end=mid-1;
            }
            else st=mid+1;
        }
        return st;
    }
    // static {
    //     Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    //         try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
    //             fw.write("0");
    //         } catch (Exception e) {
    //         }
    //     }));
    // }
}