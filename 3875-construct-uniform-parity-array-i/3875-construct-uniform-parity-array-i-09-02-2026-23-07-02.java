class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int odd = 0;

        for(int i: nums1){
            if((i&1) == 1) odd++;
        }

        boolean oddArr = (odd > 0);
        boolean evenArr = ((odd == 0) || (odd == n));
        return oddArr || evenArr;
    }
}