class Solution {
    public int gcd(int a, int b){
        return b==0 ? a : gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = -1;  
        for(int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return gcd(max, min);
    }
}