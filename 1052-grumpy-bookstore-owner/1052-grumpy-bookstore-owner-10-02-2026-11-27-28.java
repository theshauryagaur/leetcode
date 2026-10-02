class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] unsatisCust = new int[n+1];
        int[] totalCust = new int[n+1];

        for(int i=0; i<n; i++){
            unsatisCust[i+1] = unsatisCust[i] + grumpy[i]*customers[i];
            totalCust[i+1] = totalCust[i] + customers[i];
        }

        int l = 1, r = minutes;
        int maxSatis = 0;
        while(r <= n){
            int future = (totalCust[n] - totalCust[r]) - (unsatisCust[n] - unsatisCust[r]);
            int curr = totalCust[r] - totalCust[l-1];
            int past = totalCust[l-1] - unsatisCust[l-1];
            maxSatis = Math.max(maxSatis, future + curr + past);

            r++;l++;
        }
        return maxSatis;
    }
}