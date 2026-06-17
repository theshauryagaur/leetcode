class Solution {
    public char processStr(String s, long k) {
        long[] ind = new long[s.length()];
        long len = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            switch(c){
                case '*' : if(len != 0){
                    len--;
                }
                break;
                case '#' : {
                    len *= 2; 
                    break;
                }
                case '%' :  break;
                default : len++;
            }
            ind[i] = len;
        }

        if(k >= len) return '.';
        k = k+1;

        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);

            if(c == '#'){
                if(k > ind[i]/2) k = k - (ind[i]/2);
            }
            else if(c == '%'){
                k = ind[i] - k + 1;
            }
            else if(c == '*');
            else if(k == ind[i]) return s.charAt(i);
    
        }
        return '.';
    }
}