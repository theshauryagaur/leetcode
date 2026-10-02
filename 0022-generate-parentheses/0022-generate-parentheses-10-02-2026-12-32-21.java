class Solution {
    List<String> ans;
    public void help(int n, StringBuilder s, int i, int open, int close){
        if(i == 2*n){
            ans.add(s.toString());
            return;
        }

        if(open < n){
            help(n, s.append('('), i+1, open+1, close);
            s.deleteCharAt(s.length()-1);
        }
        if(open > close){
            help(n, s.append(')'), i+1, open, close+1);
            s.deleteCharAt(s.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        help(n, new StringBuilder(), 0, 0, 0);
        return ans;
    }
}