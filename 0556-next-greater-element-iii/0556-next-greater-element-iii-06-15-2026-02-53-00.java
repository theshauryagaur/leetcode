class Solution {
    public int nextGreaterElement(int n) {
        StringBuilder s = new StringBuilder(Integer.toString(n));
        int len = s.length();
        if(len == 1) return -1;

        int i=len-2;
        while(i>=0 && s.charAt(i) >= s.charAt(i+1)) i--;

        if(i >= 0){
            int j = len-1;
            while(s.charAt(j) <= s.charAt(i)) j--;

            char c = s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j, c);

            String reversed = new StringBuilder(s.substring(i+1, len)).reverse().toString();
            s.replace(i+1, len, reversed);
        }
        else return -1;

        long ans = 0;
        for(int j=0; j<len; j++){
            ans = ans*10 + (int)(s.charAt(j) - '0');
        }


        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }
}