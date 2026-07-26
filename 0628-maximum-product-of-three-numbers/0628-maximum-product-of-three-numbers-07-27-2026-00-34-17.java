class Solution {
    public int maximumProduct(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for(int i: nums){
            if(i >= a){
                c = b;
                b = a;
                a = i;
            }
            else if(i >= b){
                c = b;
                b = i;
            }
            else if(i >= c){
                c = i;
            }

            if(i <= x){
                y = x;
                x = i;
            }
            else if(i <= y){
                y = i;
            }
        }
        return Math.max(a*b*c, x*y*a);
    }
}