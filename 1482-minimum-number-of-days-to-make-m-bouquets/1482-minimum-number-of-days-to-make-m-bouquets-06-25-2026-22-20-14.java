class Solution {
    public boolean possible(int[] bloom, int day, int m, int k){
        int bou = 0;
        int cnt = 0;
        for(int i=0; i<bloom.length; i++){
            if(bloom[i] <= day){
                cnt++;
            }
            else {
                cnt = 0;
            }
            if(cnt == k){
                bou++;
                cnt = 0;
            }
        }
        return bou>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i: bloomDay){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int l=min, r=max;
        while(l<=r){
            int mid = l + (r-l)/2;

            if(possible(bloomDay, mid, m, k)==true){
                r = mid-1;
            }
            else l = mid+1;

        }
        return l;
    }
}