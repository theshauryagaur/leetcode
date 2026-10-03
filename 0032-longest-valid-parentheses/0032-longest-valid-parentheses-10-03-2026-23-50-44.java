class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int l = 0, r = 0;
        int open = 0, close = 0;

        int max = 0;

        while(r < n){
            if(s.charAt(r) == '(') open++;
            else close++;

            if(open < close){
                open = 0;
                close = 0;
                r++;
                l=r;
                continue;
            }
            else if(open == close){
                if(r-l+1 > max){
                    max = r-l+1;
                }
            }
            r++;
        }

        open = 0; close = 0;
        l = n-1; r = n-1;

        while(l>=0){
            if(s.charAt(l) == '(') open++;
            else close++;

            if(open > close){
                open = 0;
                close = 0;
                l--;
                r=l;
                continue;
            }
            else if(open == close){
                if(r-l+1 > max){
                    max = r-l+1;
                }
            }
            l--;
        }
        return max;
    }
}