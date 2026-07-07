class Solution {
    public long sumAndMultiply(int n) {
        int i = 1;
        int x = 0;
        int sum = 0;

        while(n != 0){
            int rem = n%10;
            if(rem != 0){
                x += i * rem;
                sum += rem;
                i *= 10;
            }
            n /= 10;
        }
        return (long) sum*x;
    }
}