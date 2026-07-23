class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int bits = Integer.highestOneBit(n);
        //System.out.print(bits);
        return bits*2;
    }
}