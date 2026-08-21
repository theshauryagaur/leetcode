class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diff = right-left;

        int max = Integer.highestOneBit(left);
        int high = 31 - Integer.numberOfLeadingZeros(left);
        System.out.println(max);
        System.out.println(high);
        int ans = 0;
        while(high >= 0){
            int one = (right & max);
            int two = (left & max);
            if( (one == two) && diff < max){         
        System.out.println(max);
                ans += one == 0 ? 0 :max;
                max >>= 1;
                high--;
            }
            else break;

        }
        return ans;
    }
}