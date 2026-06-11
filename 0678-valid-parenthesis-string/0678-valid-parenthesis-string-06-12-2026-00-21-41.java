class Solution {
    public boolean checkValidString(String s) {
        int left = 0;
        int right = 0;
        int star = 0;

        // CHECKS IF EVERY ) HAS A VALID (
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') left++;
            else if(c == ')'){
                if(left > 0) left--;
                else if(star > 0) star--;
                else return false;
            }
            else star++;
        }


        star = 0;
        // CHECKS IF EVERY ( HAS A VALID )
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == ')') right++;
            else if(c == '('){
                if(right > 0) right--;
                else if(star > 0) star--;
                else return false;
            }
            else star++;
        }

        return true;
    }
}