class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int y = Integer.bitCount(num2);
        int i = 30;
        int ans = 0;
        while(i >= 0){
            if(y > 0){
                if(i >= y){
                    int bit = (x & (1 << i));
                    ans |= bit; 
                    if(bit != 0) y--;
                }
                else{
                    ans |= (1<<i);
                    y--;
                }
            }
            i--;
        }
        return ans;
    }
}