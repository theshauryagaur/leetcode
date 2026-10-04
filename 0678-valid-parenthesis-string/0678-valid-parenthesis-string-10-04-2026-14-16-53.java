class Solution {
    public boolean checkValidString(String s) {
        int open = 0, close = 0, star = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') open++;
            else if(c == ')') {
                if(open > 0) open--;
                else if(star > 0){
                    star--;
                }
                else return false;
            }
            else star++;
        }

        star = 0;
        
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == '(') {
                if(close > 0) close--;
                else if(star > 0){
                    star--;
                }
                else return false;
            }
            else if(c == ')') close++;
            else star++;
        }
        return true;
    }
}