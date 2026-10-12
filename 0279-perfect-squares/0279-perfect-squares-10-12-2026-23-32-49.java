class Solution {
    int[] dp;
    List<Integer> square;
    public int helper(int n){
        if(n == 0) return 0;

        if(dp[n] != 0) return dp[n];

        int ind = Collections.binarySearch(square, n);
        if(ind < 0){
            ind = -(ind+2);
        }
        int ans = 100001;
        for(int i=ind; i>=0; i--){
            int req = 1 + helper(n-square.get(i));
            ans = Math.min(ans, req);
            if(req == 1) break;
        }
        dp[n] = ans;

        return dp[n];

    }

    // public int upperBound(int n){
    //     int st = 0, end = square.size()-1;
    //     int ans = -1;
    //     while(st<=end){
    //         int mid = (st+end)/2;

    //         int sq = square.get(mid);
    //         if(sq == n) return mid;
    //         else if(sq < n){
    //             ans = st;
    //             st = mid+1;
    //         } 
    //         else end = mid-1; 
    //     }
    //     return ans;
    // }
    public int numSquares(int n) {

        dp = new int[n+1];
        square = new ArrayList<>();

        for(int i=1; i*i<=n; i++){
            dp[i*i] = 1;
            square.add(i*i);
            if(i*i == n) return 1;
        }

        return helper(n);

    }
}