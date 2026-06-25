class Solution {
    Random random;
    int[] w;
    public Solution(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; i++){
            w[i] += w[i-1];
        }
        this.w = w;
    }
    
    public int pickIndex() {
        int n=w.length;
        if(n == 1) return 0;
        int ind = random.nextInt(w[n-1])+1;

        int l=0, r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(w[mid] == ind) return mid;
            else if(ind < w[mid]) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */