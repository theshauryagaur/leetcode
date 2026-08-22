class Solution {
    public boolean checkDivisibility(int n) {
        int x = n;
        int digSum = 0;
        int digProd = 1;
        while(x != 0){
            int dig = x%10;
            digSum += dig;
            digProd *= dig;
            x /= 10;
        }
        return (n % (digSum + digProd)) == 0;
    }
}