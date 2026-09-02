class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int odd = 0;

        for(int i: nums1){
            if((i&1) == 1) odd++;
        }

        boolean oddArr = (odd > 0); // either all odd or if there is even one odd then the even can becone odd
        boolean evenArr = ((odd == 0) || (odd == n));// either all even or all odd
        return oddArr || evenArr;
    }
}