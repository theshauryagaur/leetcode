class Solution {
    public void reverse(StringBuilder sb){
        int len = sb.length();
        for(int i=0; i<len/2; i++){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(len-i-1));
            sb.setCharAt(len-i-1, temp);
        }
    }
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '*' : if(sb.length() != 0) sb.deleteCharAt(sb.length()-1); break;
                case '#' : sb.append(sb); break;
                case '%' : reverse(sb); break;
                default : sb.append(c);
            }
        }
        return sb.toString();
    }
}