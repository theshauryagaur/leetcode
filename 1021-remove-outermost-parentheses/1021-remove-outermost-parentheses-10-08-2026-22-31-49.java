class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        
        StringBuilder ans = new StringBuilder();
        int open = 0, close = 0;
        
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(') open++;
            else close++;

            if(close == 0 && open == 1){
                continue;
            }
            if(open == close){
                open = 0;
                close = 0;
                continue;
            }

            ans.append(c);
        }
        return ans.toString();
    }
}