class Solution {
    public int digitSum(int x){
        int sum = 0;
        while(x != 0){
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i == digitSum(nums[i])) return i;
        }
        return -1;
    }
}