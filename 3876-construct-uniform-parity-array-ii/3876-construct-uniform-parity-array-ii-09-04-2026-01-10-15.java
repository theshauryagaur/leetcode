class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;
        int odd = 0, even = 0;
        Arrays.sort(nums);

        int minOdd = 2000000000;

        // if((nums[0]&1) == 1){
        //     odd++;
        //     minOdd = nums[0];
        // } 
        // else {
        //     even++;   
        // }
            

        for(int x: nums){
            if((x&1) == 1){
                odd++;
                if(minOdd < x){
                    even++;
                }
                else{
                    minOdd = x;
                }
            }
            else{
                even++;
                if(minOdd < x){
                    odd++;
                }
            }
        }
        boolean oddArr = (odd == n);
        boolean evenArr = (even == n);
        return oddArr || evenArr;
    }
}