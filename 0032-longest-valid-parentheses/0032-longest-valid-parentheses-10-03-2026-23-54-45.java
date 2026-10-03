class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int l = n-1, r = 0;
        int open = 0, close = 0;

        int max = 0;

        while(r < n){
            if(s.charAt(r) == '(') open++;
            else close++;

            if(open < close){
                open = 0;
                close = 0;
            }
            else if(open == close){
                if(2*open > max){
                    max = 2*open;
                }
            }
            r++;
        }

        open = 0; close = 0;

        while(l>=0){
            if(s.charAt(l) == '(') open++;
            else close++;

            if(open > close){
                open = 0;
                close = 0;
            }
            else if(open == close){
                if(2*open > max){
                    max = 2*open;
                }
            }
            l--;
        }
        return max;
    }
}