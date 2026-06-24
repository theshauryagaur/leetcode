class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefixsum = new int[2*n+1];
        for(int i =0; i < prefixsum.length; i++){
            prefixsum[i] = -2;
        }
        prefixsum[n] = -1;
        
        int maxlen = 0;
        int count = n;

        for(int i =0; i < nums.length; i++){
            count += 2*nums[i]-1;
            if(prefixsum[count] == -2){
                prefixsum[count] = i;
            }
            else{
                maxlen = Math.max(maxlen , i-prefixsum[count]);
            }
        }
        return maxlen;
    }
}