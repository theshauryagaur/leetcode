class Solution {
    public int nextGreaterElement(int n) {
        char[] num = (n+"").toCharArray();
        int len = num.length;

        if(len == 1) return -1;

        int i=len-2;
        while(i>=0 && num[i] >= num[i+1]) i--;

        if(i >= 0){
            int j = len-1;
            while(num[j] <= num[i]) j--;

            char c = num[i];
            num[i] = num[j];
            num[j] = c;

            Arrays.sort(num, i+1, len);
        }
        else return -1;

        long ans = 0;
        for(int j=0; j<len; j++){
            ans = ans*10 + (int)(num[j] - '0');
        }


        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }
}