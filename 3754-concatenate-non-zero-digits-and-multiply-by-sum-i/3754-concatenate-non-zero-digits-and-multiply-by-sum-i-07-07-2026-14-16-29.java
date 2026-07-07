class Solution {
    public long sumAndMultiply(int n) {
        int i = 0;
        int x = 0;
        int sum = 0;

        while(n != 0){
            int rem = n%10;
            if(rem != 0){
                x = ((int) Math.pow(10,i)*rem) + x;
                sum += rem;
                i+=1;
            }
            n /= 10;
        }
        return (long) sum*x;
    }
}