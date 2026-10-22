class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        int st = -1;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                st = i;
                break;
            }
        }

        boolean isSortedForw = true;
        for(int i=0; i<n-1; i++){
            if(nums[(st+i+1)%n] - nums[(st+i)%n] != 1) {
                isSortedForw = false;
                break;
            }
        }

        boolean isSortedBack = true;
        for(int i=0; i<n-1; i++){
            if(nums[(n+st-i-1)%n] - nums[(n+st-i)%n] != 1) {
                isSortedBack = false;
                break;
            }
        }

        if( !(isSortedForw || isSortedBack) ) return -1;

        if(isSortedForw){
            return Math.min(st , 1 + back(n, n-st-1));
        }
        if(isSortedBack){
            return Math.min(n-st, st+2);// Math.min(1(reverse) + (n-st+1) bring 0 to front , (st+1) bring zero to last + 1 (rev) );
        }
        return -1;
    }
    public int back(int n, int ind){
        return Math.min(n - ind, ind + 2);
    }
}