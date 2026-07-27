class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int a = -1;
        int b = -1;
        Arrays.sort(nums);
        for(int i: nums){
            if(i > a) {
                b=a;
                a=i;
            }
            else if(i>b) b=i;
        }
        return (a-1) * (b-1);
    }
}