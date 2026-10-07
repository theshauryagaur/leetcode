class Solution {
    public int minDelToMakeValid(String s) {
        int open = 0, close = 0;

        int ans = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') open++;
            else if(c == ')') close++;

            if(close > open) {
                ans++;
                open++;
            }
        }
        ans += open - close;
        return ans;
    }
    List<String> ans;
    HashSet<String> unique;
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int rem = minDelToMakeValid(s);

        ans = new ArrayList<>();
        unique = new HashSet<>();

        help(s, new StringBuilder(), 0, rem);

        return ans;
    }

    public void help(String s, StringBuilder sb, int i, int rem){ // rem = remDeletions;
        if(i == s.length()){
            String temp = sb.toString();
            if(isValid(sb) && !unique.contains(temp)) {
                ans.add(temp);
                unique.add(temp);
            }
            return;
        }

        char c = s.charAt(i);

        help(s, sb.append(c), i+1, rem);
        sb.deleteCharAt(sb.length()-1);
        
        if(rem > 0 && !Character.isLetter(c)){
            help(s, sb, i+1, rem-1);
        }

    }

    public boolean isValid(StringBuilder sb){
        int open = 0, close = 0;

        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '(') open++;
            else if(sb.charAt(i) == ')') close++;

            if(close > open) return false;
        }

        return open == close ? true : false;
    }
}