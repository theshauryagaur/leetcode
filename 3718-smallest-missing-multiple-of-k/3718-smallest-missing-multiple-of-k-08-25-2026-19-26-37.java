class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int max = 100/k;
        int[] mult = new int[max];

        for(int i: nums){
            if(i % k == 0){
                mult[i/k-1] = 1;
            }
        }
        for(int i=0; i<max; i++){
            if(mult[i] == 0) return (i+1)*k;
        }
        return (max+1)*k;
    }
}