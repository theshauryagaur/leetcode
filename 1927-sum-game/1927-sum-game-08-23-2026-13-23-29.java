class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int left=0, right=0;
        int lSum=0, rSum=0;

        for(int i=0; i<n/2; i++){
            char c = num.charAt(i);
            if(c == '?') left++;
            else lSum += c-'0';
        }
        for(int i=n/2; i<n; i++){
            char c = num.charAt(i);
            if(c == '?') right++;
            else rSum += c-'0';
        }

        if(lSum < rSum){
            lSum ^= rSum;
            rSum ^= lSum;
            lSum ^= rSum;

            left ^= right;
            right ^= left;
            left ^= right;
        }

        int total = left+right;
        if(total%2 == 1) return true;
        return (lSum-rSum)*2 != (right-left)*9;
        
    }
}